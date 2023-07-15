package com.news24.app.ui.activity.photo

import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Named


@Subcomponent(modules = [PhotoScreenModule::class])
interface PhotoScreenComponent {

    fun inject(activity: PhotoScreenActivity)

}


@Module
class PhotoScreenModule(
        private val startScreen: SupportAppScreen?
) {

    @Provides
    fun startScreen(): SupportAppScreen? {
        return startScreen
    }

    @Provides
    fun presenter(presenter: PhotoScreenPresenter): PhotoScreenContract.Presenter {
        return presenter
    }

}