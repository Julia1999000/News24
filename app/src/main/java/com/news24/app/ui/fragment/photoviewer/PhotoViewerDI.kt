package com.news24.app.ui.fragment.photoviewer

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.listener.ListItemClickListener
import com.news24.app.ui.fragment.photoviewer.model.PhotoViewerScreenParams
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [PhotoViewerModule::class])
interface PhotoViewerComponent {

    fun inject(fragment: PhotoViewerFragment)

}


@Module
class PhotoViewerModule(
        private val activity: Activity,
        private val params: PhotoViewerScreenParams,
        private val listItemClickListener: ListItemClickListener
) {

    @Provides
    fun presenter(presenter: PhotoViewerPresenter): PhotoViewerContract.Presenter {
        return presenter
    }

    @Provides
    @Named(value = NamedDependencies.ACTIVITY_CONTEXT)
    fun activityContext(): Context {
        return activity
    }

    @Provides
    fun provideParams(): PhotoViewerScreenParams {
        return params
    }

    @Provides
    fun provideListItemClickListener(): ListItemClickListener {
        return listItemClickListener
    }

}