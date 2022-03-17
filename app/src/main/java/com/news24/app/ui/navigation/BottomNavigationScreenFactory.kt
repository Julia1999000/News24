package com.news24.app.ui.navigation

import com.news24.app.ui.activity.main.MainScreenContract
import ru.terrakok.cicerone.android.support.SupportAppScreen


object BottomNavigationScreenFactory {

	fun getScreenForTab(tab: String?): SupportAppScreen? {
		return when (tab) {
			MainScreenContract.View.TAB_SETTINGS -> { Screens.SettingsScreen() }
			MainScreenContract.View.TAB_EVENTS -> { Screens.EventsScreen() }
			MainScreenContract.View.TAB_PROFILE -> { Screens.ProfileScreen() }
			else -> { null }
		}
	}

}