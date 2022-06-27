package com.news24.app.ui.activity.base

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Provider


@Subcomponent(modules = [BaseScreenModule::class])
interface BaseScreenComponent {

	fun provideBaseScreenPresenter(): Provider<BaseScreenContract.Presenter>

}


@Module
class BaseScreenModule {

	@Provides
	fun presenter(presenter: BaseScreenPresenter): BaseScreenContract.Presenter {
		return presenter
	}

}