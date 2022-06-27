package com.news24.app.ui.fragment.profile

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.Router
import javax.inject.Named


@Subcomponent(modules = [ProfileModule::class])
interface ProfileComponent {

	fun inject(fragment: ProfileFragment)

}


@Module
class ProfileModule(
		private val activity: Activity,
		private val router: Router? = null
) {

	@Provides
	fun presenter(presenter: ProfilePresenter): ProfileContract.Presenter {
		return presenter
	}

	@Provides
	@Named(NamedDependencies.ACTIVITY_CONTEXT)
	fun activityContext(): Context {
		return activity
	}

	@Provides
	@Named(NamedDependencies.TAB_ROUTER)
	fun router(appRouter: Router): Router {
		return this.router ?: appRouter
	}

}