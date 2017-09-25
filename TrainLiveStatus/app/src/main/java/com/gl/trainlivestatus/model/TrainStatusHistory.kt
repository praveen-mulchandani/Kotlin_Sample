package com.gl.trainlivestatus.model

import com.gl.trainlivestatus.util.converter
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.text.SimpleDateFormat

/**
 * Created by shilpi.das on 22-09-2017.
 */
@RealmClass
open class TrainStatusHistory(@PrimaryKey var id: String = SimpleDateFormat().converter(System.currentTimeMillis()),
                              var trainName: String? = null,
                              var trainNo: String? = null) : RealmObject()




