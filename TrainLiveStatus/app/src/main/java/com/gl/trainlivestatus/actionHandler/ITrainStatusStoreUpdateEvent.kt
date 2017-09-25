package com.gl.trainlivestatus.actionHandler

import com.gl.trainlivestatus.model.LiveTrainStatus

/**
 * Created by shilpi.das on 02-07-2017.
 */
interface ITrainStatusStoreUpdateEvent :IEvent {
    fun getTrainStatusResponse(): LiveTrainStatus?
    fun getTrainStatusError(): String?
}