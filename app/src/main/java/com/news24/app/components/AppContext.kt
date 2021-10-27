package com.news24.app.components

import androidx.multidex.MultiDexApplication
import com.news24.app.di.AppComponent
import com.news24.app.di.AppModule
import com.news24.app.di.DaggerAppComponent
import timber.log.Timber

class AppContext: MultiDexApplication() {

    lateinit var appComponent: AppComponent
        private set

    companion object {

        var instance: AppContext? = null
            private  set

    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        this.appComponent = initDaggerComponent()
    }

    private fun initDaggerComponent(): AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}