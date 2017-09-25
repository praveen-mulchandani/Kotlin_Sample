package com.gl.trainlivestatus.util

import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Helper class for volley
 */

class VolleyHelper private constructor() {
    val requestQueue: RequestQueue = Volley.newRequestQueue(BaseApplication.appContext)

    companion object {

        private var mInstance: VolleyHelper? = null


        /**
         * Gets the instance of volley helper class

         * @return instance of VolleyHelper Class
         */
        val instance: VolleyHelper
            get() {
                if (mInstance == null)
                    mInstance = VolleyHelper()
                //Ensure that the instance is not null
                return mInstance!!
            }
    }

}
