package com.news24.app.ui.fragment.detail.news

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.fragment.detail.news.model.NewsScreenParams
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [NewsModule::class])
interface NewsComponent {

    fun inject(fragment: NewsFragment)

}


@Module
class NewsModule(
        private val activity: Activity,
        private val params: NewsScreenParams
) {

    @Provides
    fun presenter(presenter: NewsPresenter): NewsContract.Presenter {
        return presenter
    }

    @Provides
    fun provideParams(): NewsScreenParams {
        return params
    }

    @Provides
    @Named(NamedDependencies.ACTIVITY_CONTEXT)
    fun activityContext(): Context {
        return activity
    }

}