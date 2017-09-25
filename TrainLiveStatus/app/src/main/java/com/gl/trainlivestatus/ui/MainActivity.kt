package com.gl.trainlivestatus.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.gl.trainlivestatus.R
import com.gl.trainlivestatus.actionHandler.TrainStatusStoreUpdateEvent
import com.gl.trainlivestatus.actionHandler.TrainStatusUserActionCreator
import com.gl.trainlivestatus.dependencyInjection.AppModule
import com.gl.trainlivestatus.dependencyInjection.DaggerAppComponent
import com.gl.trainlivestatus.util.BaseApplication
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import kotlinx.android.synthetic.main.activity_main_screen.*
import org.jetbrains.anko.toast
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        if (v.id == R.id.btnSubmitTrainStatus) {
            if (validateInput(etTrainNo.text.toString(), etDate.text.toString())) {
                mTrainStatusActionCreator.createTrainStatusUserAction(etTrainNo.text.toString(),
                        etDate.text.toString())
            } else {
                toast("Invalid train No or date Entered")
            }
        } else {
            datePicker(v)
        }
    }

    @Inject lateinit var mBus: Bus
    @Inject lateinit var mTrainStatusActionCreator: TrainStatusUserActionCreator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState,R.layout.activity_main_screen)
        newInjector().inject(this)
        mBus.register(this)
        initialize()
    }

    private fun initialize() {
        etDate.setOnClickListener(this)
        btnSubmitTrainStatus.setOnClickListener(this)
        btnShowHistory.setOnClickListener{
            startActivity(Intent(this, TrainHistoryActivity::class.java))
        }
    }

    @Subscribe
    fun onTrainStatusStoreUpdateEvent(event: TrainStatusStoreUpdateEvent) {
        if (event.getTrainStatusError() != null) {
            toast(event.getTrainStatusError().toString())
        } else {
            startActivity(Intent(this, TrainStatusShowActivity::class.java))
        }
    }

    /**
     * opens the date picker dialog and sets the date in EditText

     * @param view
     */
    private fun datePicker(view: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val txtDate = view as TextView

        val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    txtDate.text =
                            formatDate(dayOfMonth, monthOfYear + 1, year)
                }, year, month, day)
        datePickerDialog.show()
    }

    private fun formatDate(day: Int, month: Int, year: Int): String {
        val builder = StringBuilder()
        if (day < 10) {
            builder.append("0" + day)
        } else {
            builder.append(day)
        }
        builder.append("-")
        if (month < 10) {

            builder.append("0$month")
        } else {
            builder.append(month.toString())
        }
        builder.append("-")
        builder.append(year.toString())
        return builder.toString()
    }

    private fun validateInput(trainNo: String, date: String): Boolean {
        return !TextUtils.isEmpty(trainNo) &&
                !date.equals(resources.getString(R.string.yyyy_mm_dd)) &&
                trainNo.length == 5
    }
}
