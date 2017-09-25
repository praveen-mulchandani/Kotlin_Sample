package com.gl.trainlivestatus.util

import android.app.Application
import android.content.Context
import com.gl.trainlivestatus.dependencyInjection.AppComponent
import com.gl.trainlivestatus.dependencyInjection.AppModule
import com.gl.trainlivestatus.dependencyInjection.DaggerAppComponent
import com.gl.trainlivestatus.ui.BaseActivity
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Application class to provide instance of application
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        //Initializing the Realm DB
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME).schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    val daggerComponent = DaggerAppComponent.builder()!!

    companion object {
        /**
         * @return instance of application class
         */
        var instance: BaseApplication? = null

        /**
         * @return application context
         */
        val appContext: Context
            get() = instance!!.applicationContext
    }
}
