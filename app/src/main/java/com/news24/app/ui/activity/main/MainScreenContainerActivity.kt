package com.news24.app.ui.activity.main

import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat.Type.navigationBars
import androidx.core.view.updateLayoutParams
import com.google.android.material.navigation.NavigationBarView
import com.news24.app.R
import com.news24.app.databinding.ActivityMainFragmentContainerBinding
import com.news24.app.extensions.appspecific.isClickedInFragmentBackListener
import com.news24.app.extensions.shared.doOnApplyWindowInsets
import com.news24.app.helpers.KeyboardHelper
import com.news24.app.ui.activity.base.BaseActivity
import com.news24.app.ui.activity.main.MainScreenContract.View.Companion.TAB_EVENTS
import com.news24.app.ui.activity.main.MainScreenContract.View.Companion.TAB_PROFILE
import com.news24.app.ui.activity.main.MainScreenContract.View.Companion.TAB_SETTINGS
import com.news24.app.ui.fragment.tabcontainer.TabContainerFragment
import com.news24.app.ui.navigation.ApplicationNavigator
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Screen
import javax.inject.Inject
import javax.inject.Provider


class MainScreenContainerActivity : BaseActivity(), MainScreenContract.View {

	@InjectPresenter
	lateinit var presenter: MainScreenContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<MainScreenContract.Presenter>

	@Inject
	lateinit var navigatorHolder: NavigatorHolder

	private val navigator = ApplicationNavigator(this, -1)

	private lateinit var activityBinding: ActivityMainFragmentContainerBinding

	companion object {

		private val bottomMenuItemsInfo: Map<Int, String> = mapOf(
				R.id.navigation_settings to TAB_SETTINGS,
				R.id.navigation_events to TAB_EVENTS,
				R.id.navigation_profile to TAB_PROFILE
		)

	}

	//region ==================== Lifecycle callbacks ====================

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
		activityBinding = ActivityMainFragmentContainerBinding.inflate(layoutInflater)
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

	override fun onBackPressed() {
		val fragment = supportFragmentManager.findFragmentById(R.id.tabsContainer)
		if (fragment != null && fragment.isClickedInFragmentBackListener()) {
			return
		} else {
			presenter.onBackPressed()
		}
	}

	private val onNavigationBarItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
		val tabTag = bottomMenuItemsInfo[item.itemId]
		tabTag?.let {
			activateTab(tabTag)
		}
		return@OnItemSelectedListener true
	}

	private val onNavigationBarItemReselectedListener = NavigationBarView.OnItemReselectedListener { item ->
		val tabTag = bottomMenuItemsInfo[item.itemId]
		tabTag?.let {
			(supportFragmentManager.findFragmentByTag(it) as? TabContainerFragment)?.clearScreenStack()
		}
	}

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

	override fun activateTab(tab: String) {
		val fragmentManager = supportFragmentManager
		val transaction = fragmentManager.beginTransaction()
		for (fragmentTag in bottomMenuItemsInfo.values) {
			val fragment = fragmentManager.findFragmentByTag(fragmentTag)
			if (fragment != null) {
				if (fragment.tag == tab) {
					transaction.attach(fragment)
				} else {
					transaction.detach(fragment)
				}
			}
		}
		transaction.commitNow()
		activityBinding.apply {
			bottomNavigationView.setOnItemSelectedListener(null)
			bottomNavigationView.setOnItemReselectedListener(null)
			bottomMenuItemsInfo.entries.firstOrNull { it.value == tab }?.key?.let { menuItemId ->
				bottomNavigationView.selectedItemId = menuItemId
			}

			bottomNavigationView.setOnItemSelectedListener(onNavigationBarItemSelectedListener)
			bottomNavigationView.setOnItemReselectedListener(onNavigationBarItemReselectedListener)
		}
	}

	override fun navigateTo(screen: Screen) {
		val tag = bottomMenuItemsInfo[activityBinding.bottomNavigationView.selectedItemId]
		(supportFragmentManager.findFragmentByTag(tag) as? TabContainerFragment)?.navigateTo(screen)
	}

	override fun clearTabStack(tab: String) {
		val fragment = supportFragmentManager.findFragmentByTag(tab)
		if (fragment is TabContainerFragment) {
			fragment.clearScreenStack()
		}
	}

	//endregion


	//region ===================== UI ======================

	private fun initUI() {
		activityBinding.apply {
			bottomNavigationView.setOnItemSelectedListener(onNavigationBarItemSelectedListener)
			bottomNavigationView.setOnItemReselectedListener(onNavigationBarItemReselectedListener)

			bottomNavigationView.doOnApplyWindowInsets { view, insets, padding ->
				bottomNavigationView.updateLayoutParams<ViewGroup.MarginLayoutParams> {
					this.bottomMargin = insets.getInsets(navigationBars()).bottom
				}
			}

			initTabsContent()
		}

	}

	private fun initTabsContent() {
		addTabContainerFragment(TAB_EVENTS)
		addTabContainerFragment(TAB_SETTINGS)
		addTabContainerFragment(TAB_PROFILE)
	}

	private fun addTabContainerFragment(tag: String): TabContainerFragment {
		val fragmentManager = supportFragmentManager
		var fragment = fragmentManager.findFragmentByTag(tag) as? TabContainerFragment
		if (fragment == null) {
			fragment = TabContainerFragment.newInstance(tag)
			fragmentManager.beginTransaction()
					.add(R.id.tabsContainer, fragment, tag)
					.detach(fragment)
					.commitNow()
		}
		return fragment
	}


	//endregion


	//region ===================== Internal ======================

	//endregion

}