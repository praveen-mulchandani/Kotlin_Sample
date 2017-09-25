package com.gl.trainlivestatus.actionHandler

/**
 * Created by shilpi.das on 02-07-2017.
 */
interface ITrainStatusUserEvent : IEvent {
    fun getTrainNo(): String
    fun getJourneyDate(): String
}