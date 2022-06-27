package com.news24.app.ui.fragment.events

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.listener.ListItemClickListener
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.Router
import javax.inject.Named


@Subcomponent(modules = [EventsModule::class])
interface EventsComponent {

	fun inject(fragment: EventsFragment)

}


@Module
class EventsModule(
		private val activity: Activity,
		private val listItemClickListener: ListItemClickListener,
		private val router: Router? = null
) {

	@Provides
	fun presenter(presenter: EventsPresenter): EventsContract.Presenter {
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

	@Provides
	fun provideListItemClickListener(): ListItemClickListener {
		return listItemClickListener
	}

}