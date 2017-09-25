package com.gl.trainlivestatus.dependencyInjection

import com.gl.trainlivestatus.model.TrainStatusHistory
import com.gl.trainlivestatus.ui.BaseActivity
import com.gl.trainlivestatus.ui.MainActivity
import com.gl.trainlivestatus.ui.TrainHistoryActivity
import com.gl.trainlivestatus.ui.TrainStatusShowActivity
import dagger.Component

@Component(
        modules = arrayOf(AppModule::class)
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(trainStatusShowActivity: TrainStatusShowActivity)
    fun inject(trainHistoryActivity: TrainHistoryActivity)
}