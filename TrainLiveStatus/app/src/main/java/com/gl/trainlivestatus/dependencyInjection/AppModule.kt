package com.gl.trainlivestatus.dependencyInjection

import com.gl.trainlivestatus.actionHandler.TrainStatusUserActionCreator
import com.gl.trainlivestatus.dispatcher.Dispatcher
import com.gl.trainlivestatus.store.ITrainStatusStore
import com.gl.trainlivestatus.store.TrainStatusStore
import com.squareup.otto.Bus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * App module defining the possible dependencies
 */
@Module
@Singleton
class AppModule private constructor() {

    var mTrainStatusStore: ITrainStatusStore?=null


    @Provides
    @Singleton
    fun providesDispatcher(): Dispatcher {
        return Dispatcher(providesBus())
    }


    @Provides
    fun providesTrainStatusStore(): ITrainStatusStore {
       if( mTrainStatusStore == null)
           mTrainStatusStore = TrainStatusStore(providesBus(), providesDispatcher())

        return  mTrainStatusStore as TrainStatusStore
    }

    @Provides
    fun providesTrainStatusUserActionCreator(): TrainStatusUserActionCreator {
        return TrainStatusUserActionCreator(providesDispatcher(), providesTrainStatusStore())
    }

    companion object {
        private val sBus = Bus();
        private var sAppModule: AppModule? = null

        /**
         * Gets the app module instance

         * @return AppModule instance
         */
        val instance: AppModule
            get() {
                if (sAppModule == null) {
                    sAppModule = AppModule()
                }
                return sAppModule!!
            }
    }

    @Provides
    fun providesBus(): Bus {
        return sBus
    }
}

