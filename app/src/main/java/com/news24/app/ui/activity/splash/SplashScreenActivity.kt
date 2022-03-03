package com.news24.app.ui.activity.splash

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Bundle
import com.news24.app.R
import com.news24.app.databinding.ActivitySplashScreenBinding
import com.news24.app.ui.activity.base.BaseActivity
import com.news24.app.ui.navigation.ApplicationNavigator
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider


class SplashScreenActivity : BaseActivity(), SplashScreenContract.View {

	@InjectPresenter
	lateinit var presenter: SplashScreenContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<SplashScreenContract.Presenter>

	@Inject
	lateinit var navigatorHolder: NavigatorHolder

	private val navigator = ApplicationNavigator(this, -1)

	private lateinit var activityBinding: ActivitySplashScreenBinding


	//region ==================== Lifecycle callbacks ====================

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
		activityBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
		setContentView(activityBinding.root)

		activityBinding.animationView.addAnimatorListener(object : AnimatorListenerAdapter() {
			override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
				if (intent.extras == null) {
					presenter.onScreenLoadedWithoutExtraParams()
				} else {
					onIntentDataReceived(intent)
				}
			}
		})
	}

	override fun onResumeFragments() {
		super.onResumeFragments()
		navigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		navigatorHolder.removeNavigator()
		super.onPause()
		overridePendingTransition(0, R.anim.fade_out)
	}

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(SplashScreenModule())
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): SplashScreenContract.Presenter {
		return presenterProvider.get()
	}

	//endregion


	//region ==================== SplashScreenContract.View ====================

	//endregion


	//region ===================== Internal ======================

	private fun onIntentDataReceived(intent: Intent) {
		val bundle = intent.extras
		val data = bundle?.keySet()
				?.map { Pair<String, Any>(it, intent.extras!!.get(it)!!) }
				?.toMap() ?: emptyMap()
		presenter.onExtraParamsReceived(data)
	}

	//endregion

}