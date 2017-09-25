package com.gl.trainlivestatus.ui

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.gl.trainlivestatus.R
import com.gl.trainlivestatus.dependencyInjection.AppComponent
import com.gl.trainlivestatus.dependencyInjection.AppModule
import com.gl.trainlivestatus.util.BaseApplication

open class BaseActivity : AppCompatActivity() {

     fun onCreate(savedInstanceState: Bundle?,layoutResourceId: Int) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        val tool = findViewById(R.id.tool_bar) as android.support.v7.widget.Toolbar
        tool.textAlignment = View.TEXT_ALIGNMENT_CENTER
        setSupportActionBar(tool)
        supportActionBar?.title = resources.getString(R.string.app_name)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.darkOrange)
        }
    }

    /**
     * Convenience method for creating the  injector

     * @return a new instance of the presentation injector
     */
    protected fun newInjector(): AppComponent {
        return BaseApplication.instance!!.daggerComponent.appModule(AppModule.instance)
                .build()
    }
}
