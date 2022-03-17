package com.news24.app.ui.fragment.tabcontainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news24.app.R
import com.news24.app.extensions.appspecific.isClickedInFragmentBackListener
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.navigation.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

class TabContainerFragment : BaseFragment(), RouterProvider, BackButtonListener {

	private var navigator: Navigator? = null

	@Inject
	lateinit var ciceroneHolder: LocalCiceroneHolder

	private val containerName: String?
		get() = requireArguments().getString(EXTRA_NAME)

	val cicerone: Cicerone<Router>
		get() = ciceroneHolder.getCicerone(containerName!!)

	companion object {
		private val EXTRA_NAME = "extra_name"

		fun newInstance(name: String): TabContainerFragment {
			val fragment = TabContainerFragment()

			fragment.arguments = Bundle().apply {
				putString(EXTRA_NAME, name)
			}

			return fragment
		}
	}

	//region ==================== Lifecycle callbacks ====================

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_tab_container, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		if (childFragmentManager.findFragmentById(R.id.tab_container) == null) {
			replaceBottomNavigationScreen()
		}

		super.onViewCreated(view, savedInstanceState)
	}

	private fun replaceBottomNavigationScreen() {
		val screen = BottomNavigationScreenFactory.getScreenForTab(containerName)
		if (screen != null) {
			cicerone.router.replaceScreen(screen)
		}
	}

	override fun onResume() {
		super.onResume()
		cicerone.navigatorHolder.setNavigator(getNavigator())
	}

	override fun onPause() {
		cicerone.navigatorHolder.removeNavigator()
		super.onPause()
	}

	//endregion


	//region ==================== Navigation ====================

	private fun getNavigator(): Navigator {
		if (navigator == null) {
			navigator = ApplicationNavigator(requireActivity(), childFragmentManager, R.id.tab_container)
		}
		return navigator!!
	}

	override fun getRouter(): Router {
		return cicerone.router
	}

	override fun onBackPressed(): Boolean {
		val fragment = childFragmentManager.findFragmentById(R.id.tab_container)
		if (fragment != null && fragment.isClickedInFragmentBackListener()) {
			return true
		} else {
			if (childFragmentManager.backStackEntryCount > 0) {
				getRouter().exit()
				return true
			} else if (activity is RouterProvider) {
				(activity as RouterProvider).getRouter().exit()
				return true
			}
		}
		return false
	}

	fun navigateTo(screen: Screen) {
		getRouter().navigateTo(screen)
	}

	fun clearScreenStack() {
		getRouter().backTo(null)
	}

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		getAppComponent().inject(this)
	}

	//endregion

}