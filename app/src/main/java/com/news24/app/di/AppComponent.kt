package com.news24.app.di

import com.news24.app.components.AppContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
        AppModule::class,
        NavigationModule::class,
        LocalNavigationModule::class
])
interface AppComponent {

    fun inject(appContext: AppContext)

}