package com.news24.app.ui.fragment.events

import android.app.Activity
import android.content.Context
import com.news24.app.di.NamedDependencies
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [EventsScreenModule::class])
interface EventsScreenComponent {

	fun inject(fragment: EventsScreenFragment)

}


@Module
class EventsScreenModule(private val activity: Activity) {

	@Provides
	fun presenter(eventsScreenPresenter: EventsScreenPresenter): EventsScreenContract.Presenter {
		return eventsScreenPresenter
	}

	@Provides
	@Named(NamedDependencies.ACTIVITY_CONTEXT)
	fun activityContext(): Context {
		return activity
	}

}