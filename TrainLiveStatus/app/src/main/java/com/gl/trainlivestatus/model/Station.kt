package com.gl.trainlivestatus.model

import com.google.gson.annotations.SerializedName

/**
 * Created by shilpi.das on 01-07-2017.
 */
data class Station (@SerializedName("name") var mName: String,
                    @SerializedName("code") var mCode: String)