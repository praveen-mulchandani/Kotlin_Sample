package com.gl.trainlivestatus.actionHandler

import com.gl.trainlivestatus.model.LiveTrainStatus

/**
 * Created by shilpi.das on 02-07-2017.
 */
class TrainStatusStoreUpdateEvent(private val trainStatusModel: LiveTrainStatus?,
                                  private val error: String?) : ITrainStatusStoreUpdateEvent {
    override fun getTrainStatusResponse(): LiveTrainStatus? {
        return trainStatusModel
    }

    override fun getTrainStatusError(): String? {
        return error
    }
}