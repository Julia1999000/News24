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
        lateinit var instance: AppContext
            private  set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        Timber.plant(Timber.DebugTree())

        this.appComponent = initDaggerComponent()
    }

    private fun initDaggerComponent(): AppComponent {
        return DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

}