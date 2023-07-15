package com.news24.app.ui.activity.container

import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Named


@Subcomponent(modules = [ContainerScreenModule::class])
interface ContainerScreenComponent {

	fun inject(activity: ContainerScreenActivity)

}


@Module
class ContainerScreenModule(
		private val startScreen: SupportAppScreen?
) {

	@Provides
	@Named(NamedDependencies.START_SCREEN)
	fun startScreen(): SupportAppScreen? {
		return startScreen
	}

	@Provides
	fun presenter(presenter: ContainerScreenPresenter): ContainerScreenContract.Presenter {
		return presenter
	}

}