package com.gl.trainlivestatus.actionHandler

/**
 * Created by shilpi.das on 02-07-2017.
 */
class TrainStatusUserEvent(private val mTrainNo: String, private val mJourneyDate: String) : ITrainStatusUserEvent {
    override fun getTrainNo(): String {
        return mTrainNo
    }

    override fun getJourneyDate(): String {
        return mJourneyDate
    }
}