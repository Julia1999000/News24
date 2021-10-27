package com.news24.app.di

import android.content.Context
import com.news24.app.components.AppContext
import com.news24.app.ui.other.resources.ResourceProvider
import com.news24.app.ui.other.resources.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: AppContext) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideResourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider {
        return resourceProviderImpl
    }

}