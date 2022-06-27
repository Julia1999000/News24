package com.news24.app.ui.fragment.onboarding

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [OnboardingModule::class])
interface OnboardingComponent {

	fun inject(fragment: OnboardingFragment)

}


@Module
class OnboardingModule(private val activity: Activity) {

	@Provides
	fun presenter(presenter: OnboardingPresenter): OnboardingContract.Presenter {
		return presenter
	}

	@Provides
	@Named(NamedDependencies.ACTIVITY_CONTEXT)
	fun activityContext(): Context {
		return activity
	}

}