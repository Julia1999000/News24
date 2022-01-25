package com.news24.app.ui.activity.main

import android.os.Bundle
import com.news24.app.databinding.ActivityMainScreenBinding
import com.news24.app.helpers.KeyboardHelper
import com.news24.app.ui.activity.base.BaseActivity
import com.news24.app.ui.navigation.ApplicationNavigator
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider


class MainScreenActivity : BaseActivity(), MainScreenContract.View {

	@InjectPresenter
	lateinit var presenter: MainScreenContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<MainScreenContract.Presenter>

	@Inject
	lateinit var navigatorHolder: NavigatorHolder

	private val navigator = ApplicationNavigator(this, -1)
	private lateinit var activityBinding: ActivityMainScreenBinding

	//region ==================== Lifecycle callbacks ====================

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
		activityBinding = ActivityMainScreenBinding.inflate(layoutInflater)
		setContentView(activityBinding.root)

		initUI()
	}

	override fun onResumeFragments() {
		super.onResumeFragments()
		navigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		navigatorHolder.removeNavigator()
		KeyboardHelper.removeKeyboardListener(activityBinding.rootView)
		super.onPause()
	}

	//endregion


	//region ==================== UI handlers ====================

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(MainScreenModule())
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): MainScreenContract.Presenter {
		return presenterProvider.get()
	}

	//endregion


	//region ==================== MainScreenContract.View ====================

	//endregion


	//region ===================== UI ======================

	private fun initUI() {

	}

	//endregion


	//region ===================== Internal ======================

	//endregion


}