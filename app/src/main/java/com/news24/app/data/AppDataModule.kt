package com.news24.app.data

import com.news24.app.data.entities.app.AppService
import com.news24.app.data.entities.app.AppServiceImpl
import com.news24.app.data.entities.events.EventsService
import com.news24.app.data.entities.events.EventsServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppDataModule {

	//region ===================== AppService ======================

	@Provides
	@Singleton
	fun provideAppService(appServiceImpl: AppServiceImpl): AppService {
		return appServiceImpl
	}

	//endregion

	// region ===================== Events ======================

	@Provides
	@Singleton
	fun provideEventsService(serviceImpl: EventsServiceImpl): EventsService {
		return serviceImpl
	}

	//endregion

}