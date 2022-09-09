package com.news24.app.ui.fragment.detail.photoalbum

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.listener.ListItemClickListener
import com.news24.app.ui.fragment.detail.photoalbum.model.PhotoAlbumScreenParams
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [PhotoAlbumModule::class])
interface PhotoAlbumComponent {

    fun inject(fragment: PhotoAlbumFragment)

}


@Module
class PhotoAlbumModule(
        private val activity: Activity,
        private val listItemClickListener: ListItemClickListener,
        private val params: PhotoAlbumScreenParams
) {

    @Provides
    fun presenter(presenter: PhotoAlbumPresenter): PhotoAlbumContract.Presenter {
        return presenter
    }

    @Provides
    fun provideParams(): PhotoAlbumScreenParams {
        return params
    }

    @Provides
    @Named(value = NamedDependencies.ACTIVITY_CONTEXT)
    fun activityContext(): Context {
        return activity
    }

    @Provides
    fun provideListItemClickListener(): ListItemClickListener {
        return listItemClickListener
    }

}