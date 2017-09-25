package com.gl.trainlivestatus.ui

import android.os.Bundle
import com.gl.trainlivestatus.R
import com.gl.trainlivestatus.store.ITrainStatusStore
import kotlinx.android.synthetic.main.activity_train_status_show.*
import javax.inject.Inject

class TrainStatusShowActivity : BaseActivity() {
    @Inject lateinit var mStore: ITrainStatusStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, R.layout.activity_train_status_show)
        newInjector().inject(this)

        val liveTrainStatus = mStore.getCurrentState()

        if (liveTrainStatus?.mResponseCode == "200") {
            val stringBuilder = StringBuilder()
            stringBuilder.append("Current Station: ")
            val currentStation = liveTrainStatus.mCurrentStation
            stringBuilder.append(currentStation.mStations.mName)
            stringBuilder.append("\n Arrived: ")
            if (currentStation.mHasArrived) {
                stringBuilder.append("Yes")
            } else {
                stringBuilder.append("No")
            }
            stringBuilder.append("\nSchedule Arrival:")
            stringBuilder.append(currentStation.mSchArrDate)
            stringBuilder.append(" " + currentStation.mSchArr)
            stringBuilder.append("\nPosition: ")
            stringBuilder.append(liveTrainStatus.mPosition)
            tvTrainStatusShow.text = stringBuilder.toString()
        } else {
            tvTrainStatusShow.text = getString(R.string.data_not_available)
        }
    }
}
