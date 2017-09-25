package com.gl.trainlivestatus.actionHandler

/**
 * Created by shilpi.das on 02-07-2017.
 */
interface ITrainStatusUserActionCreator {
    fun  createTrainStatusUserAction(trainNo: String, date: String)
}