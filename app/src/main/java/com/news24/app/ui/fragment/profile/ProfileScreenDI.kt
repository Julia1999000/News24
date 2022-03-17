package com.news24.app.ui.fragment.profile

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [ProfileScreenModule::class])
interface ProfileScreenComponent {

	fun inject(fragment: ProfileScreenFragment)

}


@Module
class ProfileScreenModule(private val activity: Activity) {

	@Provides
	fun presenter(profileScreenPresenter: ProfileScreenPresenter): ProfileScreenContract.Presenter {
		return profileScreenPresenter
	}

	@Provides
	@Named(NamedDependencies.ACTIVITY_CONTEXT)
	fun activityContext(): Context {
		return activity
	}

}