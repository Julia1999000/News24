package com.news24.app.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {
	private val cicerone = Cicerone.create()

	@Provides
	@Singleton
	fun provideCicerone(): Cicerone<Router> {
		return cicerone
	}

	@Provides
	@Singleton
	fun provideRouter(): Router {
		return cicerone.router
	}


	@Provides
	@Singleton
	fun provideNavigatorHolder(): NavigatorHolder {
		return cicerone.navigatorHolder
	}

}