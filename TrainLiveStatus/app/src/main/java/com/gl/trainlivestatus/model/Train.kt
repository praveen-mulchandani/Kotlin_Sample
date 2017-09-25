package com.gl.trainlivestatus.model

import com.google.gson.annotations.SerializedName

/**
 * Created by shilpi.das on 07-07-2017.
 */
data class Train(@SerializedName("name") var mName: String,
                 @SerializedName("number") var mNumber: String)