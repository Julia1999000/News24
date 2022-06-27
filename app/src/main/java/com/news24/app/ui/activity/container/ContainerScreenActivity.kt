package com.news24.app.ui.activity.container

import android.os.Bundle
import android.os.Parcelable
import com.news24.app.R
import com.news24.app.components.AppContext
import com.news24.app.databinding.ActivityContainerScreenBinding
import com.news24.app.ui.activity.base.BaseScreenActivity
import com.news24.app.ui.navigation.ApplicationNavigator
import com.news24.app.ui.navigation.BackButtonListener
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject
import javax.inject.Provider


class ContainerScreenActivity : BaseScreenActivity(), ContainerScreenContract.View {

	companion object {

		const val EXTRA_START_SCREEN = "EXTRA_START_SCREEN"

	}

	@InjectPresenter
	lateinit var presenter: ContainerScreenContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<ContainerScreenContract.Presenter>

	@Inject
	lateinit var navigatorHolder: NavigatorHolder

	private val navigator = ApplicationNavigator(this, R.id.contentContainer)

	private lateinit var activityBinding: ActivityContainerScreenBinding


	//region ==================== Lifecycle callbacks ====================

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
		activityBinding = ActivityContainerScreenBinding.inflate(layoutInflater)
		setContentView(activityBinding.root)
	}

	override fun onResumeFragments() {
		super.onResumeFragments()
		navigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		navigatorHolder.removeNavigator()
		super.onPause()
	}

	override fun onBackPressed() {
		val fragment = supportFragmentManager.findFragmentById(R.id.contentContainer)
		if (fragment != null
				&& fragment is BackButtonListener
				&& (fragment as BackButtonListener).onBackPressed()
		) {
			return
		} else {
			super.onBackPressed()
		}
	}

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val startScreen = intent.getParcelableExtra<Parcelable>(EXTRA_START_SCREEN) as SupportAppScreen

		val component = AppContext.instance.appComponent.plus(ContainerScreenModule(startScreen))
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): ContainerScreenContract.Presenter {
		return presenterProvider.get()
	}

	//endregion


	//region ==================== ContainerScreenContract.View ====================

	//endregion

}