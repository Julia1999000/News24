package com.news24.app.ui.activity.main

import dagger.Module
import dagger.Provides
import dagger.Subcomponent


@Subcomponent(modules = [MainScreenModule::class])
interface MainScreenComponent {

	fun inject(activity: MainScreenActivity)

}


@Module
class MainScreenModule() {

	@Provides
	fun presenter(presenter: MainScreenPresenter): MainScreenContract.Presenter {
		return presenter
	}

}