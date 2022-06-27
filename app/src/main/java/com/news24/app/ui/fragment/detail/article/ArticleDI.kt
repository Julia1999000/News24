package com.news24.app.ui.fragment.detail.article

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.fragment.detail.article.model.ArticleScreenParams
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [ArticleModule::class])
interface ArticleComponent {

    fun inject(fragment: ArticleFragment)

}


@Module
class ArticleModule(
        private val activity: Activity,
        private val params: ArticleScreenParams
) {

    @Provides
    fun presenter(presenter: ArticlePresenter): ArticleContract.Presenter {
        return presenter
    }

    @Provides
    fun provideParams(): ArticleScreenParams {
        return params
    }

    @Provides
    @Named(NamedDependencies.ACTIVITY_CONTEXT)
    fun activityContext(): Context {
        return activity
    }

}