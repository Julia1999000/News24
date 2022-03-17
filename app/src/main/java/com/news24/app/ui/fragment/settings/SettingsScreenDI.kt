package com.news24.app.ui.fragment.settings

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [SettingsScreenModule::class])
interface SettingsScreenComponent {

	fun inject(fragment: SettingsScreenFragment)

}


@Module
class SettingsScreenModule(private val activity: Activity) {

	@Provides
	fun presenter(settingsScreenPresenter: SettingsScreenPresenter): SettingsScreenContract.Presenter {
		return settingsScreenPresenter
	}

	@Provides
	@Named(NamedDependencies.ACTIVITY_CONTEXT)
	fun activityContext(): Context {
		return activity
	}

}