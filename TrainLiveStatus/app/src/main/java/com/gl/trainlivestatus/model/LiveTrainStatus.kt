package com.gl.trainlivestatus.model

import com.google.gson.annotations.SerializedName

/**
 * Created by shilpi.das on 01-07-2017.
 */
data class LiveTrainStatus(@SerializedName("current_station") var mCurrentStation: CurrentStation,
                           @SerializedName("position") var mPosition: String,
                           @SerializedName("route") var mRoute: Array<Route>,
                           @SerializedName("response_code") var mResponseCode: String,
                           @SerializedName("train_number") var mTrainNo: String,
                           @SerializedName("train") var mTrain: Train,
                           @SerializedName("debit") var mDebit: String,
                           @SerializedName("start_date") var mStartDate: String
)