package com.news24.app.ui.fragment.preloaderdialog

import dagger.Module
import dagger.Provides
import dagger.Subcomponent


@Subcomponent(modules = [PreloaderDialogModule::class])
interface PreloaderDialogComponent {

    fun inject(fragment: PreloaderDialogFragment)

}


@Module
class PreloaderDialogModule {

    @Provides
    fun presenter(presenter: PreloaderDialogPresenter): PreloaderDialogContract.Presenter {
        return presenter
    }

}