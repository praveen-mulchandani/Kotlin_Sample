package com.gl.trainlivestatus.store

import com.gl.trainlivestatus.model.TrainStatusHistory
import io.realm.Realm
import io.realm.RealmResults

/**
 * Data provider class
 */
object TrainStatusDataProvider{

    private val mRealm = Realm.getDefaultInstance()
    /**
     * Gets the Train Status List

     * @return RealmResults list
     */
    val getTrainHistoryList: RealmResults<TrainStatusHistory>?
        get() = mRealm.where(TrainStatusHistory::class.java).findAll()

    /**
     *
     */
    fun addTrainStatus(trainStatusModel: TrainStatusHistory) {
        mRealm.beginTransaction()
        mRealm.copyToRealm(trainStatusModel)
        mRealm.commitTransaction()
    }
}