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
import com.news24.app.ui.fragment.detail.article.ArticleModule
import com.news24.app.ui.fragment.detail.article.ArticleComponent
import com.news24.app.ui.fragment.detail.broadcast.BroadcastComponent
import com.news24.app.ui.fragment.detail.broadcast.BroadcastModule
import com.news24.app.ui.fragment.detail.news.NewsComponent
import com.news24.app.ui.fragment.detail.news.NewsModule
import com.news24.app.ui.fragment.detail.photoalbum.PhotoAlbumComponent
import com.news24.app.ui.fragment.detail.photoalbum.PhotoAlbumModule
import com.news24.app.ui.fragment.events.EventsComponent
import com.news24.app.ui.fragment.events.EventsModule
import com.news24.app.ui.fragment.onboarding.OnboardingComponent
import com.news24.app.ui.fragment.onboarding.OnboardingModule
import com.news24.app.ui.fragment.preloaderdialog.PreloaderDialogComponent
import com.news24.app.ui.fragment.preloaderdialog.PreloaderDialogModule
import com.news24.app.ui.fragment.profile.ProfileComponent
import com.news24.app.ui.fragment.profile.ProfileModule
import com.news24.app.ui.fragment.settings.SettingsComponent
import com.news24.app.ui.fragment.settings.SettingsModule
import com.news24.app.ui.fragment.tabcontainer.TabContainerFragment
import com.news24.app.ui.fragment.webview.WebViewComponent
import com.news24.app.ui.fragment.webview.WebViewModule
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

    fun plus(module: OnboardingModule): OnboardingComponent

    fun plus(module: EventsModule): EventsComponent

    fun plus(module: ProfileModule): ProfileComponent

    fun plus(module: SettingsModule): SettingsComponent

    fun plus(module: ArticleModule): ArticleComponent

    fun plus(module: WebViewModule): WebViewComponent

    fun plus(module: NewsModule): NewsComponent

    fun plus(module: PreloaderDialogModule): PreloaderDialogComponent

    fun plus(module: BroadcastModule): BroadcastComponent

    fun plus(module: PhotoAlbumModule): PhotoAlbumComponent

}