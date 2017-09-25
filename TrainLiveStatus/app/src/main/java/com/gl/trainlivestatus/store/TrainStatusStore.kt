package com.gl.trainlivestatus.store

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.gl.trainlivestatus.R
import com.gl.trainlivestatus.actionHandler.TrainStatusStoreUpdateEvent
import com.gl.trainlivestatus.actionHandler.TrainStatusUserEvent
import com.gl.trainlivestatus.dispatcher.Dispatcher
import com.gl.trainlivestatus.model.LiveTrainStatus
import com.gl.trainlivestatus.model.TrainStatusHistory
import com.gl.trainlivestatus.util.BaseApplication
import com.gl.trainlivestatus.util.ParseJsonData
import com.gl.trainlivestatus.util.VolleyHelper
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import io.realm.RealmResults
import org.json.JSONObject
import java.net.URLEncoder
import javax.inject.Inject


class TrainStatusStore @Inject constructor(mBus: Bus, private val mDispatcher: Dispatcher) : ITrainStatusStore {

    private var url = ""
    private var liveTrainStatus: LiveTrainStatus? = null
    private var error: String? = null
    private val TAG = javaClass.canonicalName
    private var flag = false

    init {
        mBus.register(this)
    }

    @Subscribe
    fun observeUserActionEvent(event: TrainStatusUserEvent) {
        url = getUrl(event)
        requestJsonObject()

    }

    private fun requestJsonObject() {
        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url,
                Response.Listener<JSONObject> { response ->

                    //Parse Json data and store in TrainStatus Model
                    liveTrainStatus = ParseJsonData.getModel(response.toString(),
                            LiveTrainStatus::class.java) as LiveTrainStatus
                    dispatcherStoreChangeEvent(liveTrainStatus, error)
                    saveData(liveTrainStatus as LiveTrainStatus)

                }, Response.ErrorListener { volleyError ->
            error = volleyError.message
            dispatcherStoreChangeEvent(liveTrainStatus, error)
        }) {}
        VolleyHelper.instance.requestQueue.add(jsonObjectRequest)
    }

    private fun saveData(liveTrainStatus: LiveTrainStatus) {
        if (liveTrainStatus.mResponseCode == "200") {
            val trainName = liveTrainStatus.mTrain.mName
            val trainNo = liveTrainStatus.mTrainNo
            val trainStatusModel: TrainStatusHistory = TrainStatusHistory(trainName = trainName,
                    trainNo = trainNo)
            TrainStatusDataProvider.addTrainStatus(trainStatusModel)
        }
    }

    private fun dispatcherStoreChangeEvent(liveTrainStatus: LiveTrainStatus?, error: String?) {
        mDispatcher.dispatch(TrainStatusStoreUpdateEvent(liveTrainStatus, error))
    }

    private fun getUrl(event: TrainStatusUserEvent): String {
        val stringBuilder = StringBuilder(BaseApplication.appContext.resources.getString(R.string.train_status_base_url))
        stringBuilder.append(event.getTrainNo())
        stringBuilder.append(BaseApplication.appContext.resources.getString(R.string.doj))
        stringBuilder.append(URLEncoder.encode(event.getJourneyDate(), "UTF-8"))
        stringBuilder.append(BaseApplication.appContext.resources.getString(R.string.api_key))
        Log.i(TAG, stringBuilder.toString())
        return stringBuilder.toString()
    }

    override fun getCurrentState(): LiveTrainStatus? {
        return liveTrainStatus
    }

    override fun getTrainHistory(): RealmResults<TrainStatusHistory>? {
        return  TrainStatusDataProvider.getTrainHistoryList
    }

}
