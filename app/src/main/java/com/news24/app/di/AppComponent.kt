package com.news24.app.di

import com.news24.app.components.AppContext
import com.news24.app.data.AppDataModule
import com.news24.app.ui.activity.base.BaseScreenComponent
import com.news24.app.ui.activity.base.BaseScreenModule
import com.news24.app.ui.activity.main.MainScreenComponent
import com.news24.app.ui.activity.main.MainScreenModule
import com.news24.app.ui.activity.splash.SplashScreenComponent
import com.news24.app.ui.activity.splash.SplashScreenModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
        AppModule::class,
        NavigationModule::class,
        LocalNavigationModule::class,
        AppDataModule::class
])
interface AppComponent {

    fun inject(appContext: AppContext)

    fun plus(module: BaseScreenModule): BaseScreenComponent

    fun plus(module: MainScreenModule): MainScreenComponent

    fun plus(module: SplashScreenModule): SplashScreenComponent

}