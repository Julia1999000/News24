package com.news24.app.ui.fragment.detail.broadcast

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.fragment.detail.broadcast.model.BroadcastScreenParams
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [BroadcastModule::class])
interface BroadcastComponent {

    fun inject(fragment: BroadcastFragment)

}


@Module
class BroadcastModule(
        private val activity: Activity,
        private val params: BroadcastScreenParams
) {

    @Provides
    fun presenter(presenter: BroadcastPresenter): BroadcastContract.Presenter {
        return presenter
    }

    @Provides
    fun provideParams(): BroadcastScreenParams {
        return params
    }

    @Provides
    @Named(NamedDependencies.ACTIVITY_CONTEXT)
    fun activityContext(): Context {
        return activity
    }

}