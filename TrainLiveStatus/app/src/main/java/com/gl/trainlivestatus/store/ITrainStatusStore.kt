package com.gl.trainlivestatus.store

import com.gl.trainlivestatus.model.LiveTrainStatus
import com.gl.trainlivestatus.model.TrainStatusHistory
import io.realm.RealmResults

/**
 * Created by shilpi.das on 03-07-2017.
 */
interface ITrainStatusStore {
    fun getCurrentState(): LiveTrainStatus?
    fun getTrainHistory(): RealmResults<TrainStatusHistory>?
}