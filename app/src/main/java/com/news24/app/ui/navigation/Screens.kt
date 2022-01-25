package com.news24.app.ui.navigation

import android.content.Context
import android.content.Intent
import com.news24.app.ui.activity.main.MainScreenActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

	class MainScreen : SupportAppScreen() {
		override fun getActivityIntent(context: Context): Intent {
			val intent = Intent(context, MainScreenActivity::class.java)
			intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

			return intent
		}
	}

}