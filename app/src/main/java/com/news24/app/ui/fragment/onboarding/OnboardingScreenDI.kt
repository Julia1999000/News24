package com.news24.app.ui.fragment.onboarding

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named

@Subcomponent(modules = [OnboardingScreenModule::class])
interface OnboardingScreenComponent {

	fun inject(fragment: OnboardingScreenFragment)

}

@Module
class OnboardingScreenModule(private val activity: Activity) {

	@Provides
	fun presenter(onboardingScreenPresenter: OnboardingScreenPresenter): OnboardingScreenContract.Presenter {
		return onboardingScreenPresenter
	}

	@Provides
	@Named(NamedDependencies.ACTIVITY_CONTEXT)
	fun activityContext(): Context {
		return activity
	}

}