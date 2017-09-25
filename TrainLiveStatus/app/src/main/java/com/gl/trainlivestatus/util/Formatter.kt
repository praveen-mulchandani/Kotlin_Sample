package com.gl.trainlivestatus.util

import com.gl.trainlivestatus.dependencyInjection.AppComponent
import com.gl.trainlivestatus.dependencyInjection.AppModule
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by shilpi.das on 23-09-2017.
 */
fun SimpleDateFormat.converter(time: Long): String {
    val sdf = SimpleDateFormat("MMM dd,yyyy HH:mm")
    return sdf.format(Date(time))

}