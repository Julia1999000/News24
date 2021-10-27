package com.news24.app.di

import com.news24.app.ui.navigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalNavigationModule {

	@Provides
	@Singleton
	internal fun provideLocalNavigationHolder(): LocalCiceroneHolder {
		return LocalCiceroneHolder()
	}

}
