package com.gl.trainlivestatus.util

import com.google.gson.GsonBuilder

/**
 * Created by shilpi.das on 11-06-2017.
 */
class ParseJsonData {
    companion object {
        fun getModel(response: String, modelClass: Class<*>): Any {
            val gson = GsonBuilder().create()
            return gson.fromJson(response, modelClass)
        }
    }
}
