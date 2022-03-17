package com.news24.app.di

import com.news24.app.components.AppContext
import com.news24.app.data.AppDataModule
import com.news24.app.ui.activity.base.BaseScreenComponent
import com.news24.app.ui.activity.base.BaseScreenModule
import com.news24.app.ui.activity.container.ContainerScreenComponent
import com.news24.app.ui.activity.container.ContainerScreenModule
import com.news24.app.ui.activity.main.MainScreenComponent
import com.news24.app.ui.activity.main.MainScreenModule
import com.news24.app.ui.activity.splash.SplashScreenComponent
import com.news24.app.ui.activity.splash.SplashScreenModule
import com.news24.app.ui.fragment.events.EventsScreenComponent
import com.news24.app.ui.fragment.events.EventsScreenModule
import com.news24.app.ui.fragment.onboarding.OnboardingScreenComponent
import com.news24.app.ui.fragment.onboarding.OnboardingScreenModule
import com.news24.app.ui.fragment.profile.ProfileScreenComponent
import com.news24.app.ui.fragment.profile.ProfileScreenModule
import com.news24.app.ui.fragment.settings.SettingsScreenComponent
import com.news24.app.ui.fragment.settings.SettingsScreenModule
import com.news24.app.ui.fragment.tabcontainer.TabContainerFragment
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

    fun inject(tabContainerFragment: TabContainerFragment)

    fun plus(module: BaseScreenModule): BaseScreenComponent

    fun plus(module: MainScreenModule): MainScreenComponent

    fun plus(module: SplashScreenModule): SplashScreenComponent

    fun plus(module: ContainerScreenModule): ContainerScreenComponent

    fun plus(module: OnboardingScreenModule): OnboardingScreenComponent

    fun plus(module: EventsScreenModule): EventsScreenComponent

    fun plus(module: ProfileScreenModule): ProfileScreenComponent

    fun plus(module: SettingsScreenModule): SettingsScreenComponent

}