package com.gl.trainlivestatus.model

import com.google.gson.annotations.SerializedName

/**
 * Created by shilpi.das on 01-07-2017.
 */
data class CurrentStation(@SerializedName("has_departed") var mHasDeparted: Boolean,
                          @SerializedName("station") var mStation: Station,
                          @SerializedName("status") var mStatus: String,
                          @SerializedName("no") var mNo: Int,
                          @SerializedName("station_") var mStations: Station,
                          @SerializedName("distance") var mDistance: String,
                          @SerializedName("scharr") var mSchArr: String,
                          @SerializedName("actarr") var mActArr: String,
                          @SerializedName("schdep") var mSchDep: String,
                          @SerializedName("latemin") var mLateMin: String,
                          @SerializedName("actdep") var mActDep: String,
                          @SerializedName("scharr_date") var mSchArrDate: String,
                          @SerializedName("day") var mDay: String,
                          @SerializedName("actarr_date") var mActArrDate: String,
                          @SerializedName("has_arrived") var mHasArrived: Boolean)