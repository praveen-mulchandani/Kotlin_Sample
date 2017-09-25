package com.gl.trainlivestatus.actionHandler

import com.gl.trainlivestatus.dispatcher.Dispatcher
import com.gl.trainlivestatus.store.ITrainStatusStore
import com.gl.trainlivestatus.store.TrainStatusStore

/**
 * Created by shilpi.das on 01-07-2017.
 */
class TrainStatusUserActionCreator(val dispatcher: Dispatcher,store: ITrainStatusStore) : ITrainStatusUserActionCreator {
    override fun createTrainStatusUserAction(trainNo: String, date: String) {
        dispatcher.dispatch(TrainStatusUserEvent(trainNo, date))

    }
}