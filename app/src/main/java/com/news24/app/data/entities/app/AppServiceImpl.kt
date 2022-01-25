package com.news24.app.data.entities.app

import android.content.Context
import androidx.core.content.edit
import com.ironz.binaryprefs.BinaryPreferencesBuilder
import javax.inject.Inject

class AppServiceImpl @Inject constructor(context: Context) : AppService {

	companion object {

		const val PREFERENCES_FILENAME = "onboarding_settings"

		const val KEY_SHOULD_SHOW_ONBOARDING_SCREEN = "should_show_onboarding_screen"

	}

	private val preferences = BinaryPreferencesBuilder(context)
			.name(PREFERENCES_FILENAME)
			.build()

	//region ==================== UserService ====================

	override fun isShouldShowOnboardingScreen(): Boolean {
		return preferences.getBoolean(KEY_SHOULD_SHOW_ONBOARDING_SCREEN, true)
	}

	override fun setShouldShowOnboardingScreen(shouldShow: Boolean) {
		preferences.edit {
			putBoolean(KEY_SHOULD_SHOW_ONBOARDING_SCREEN, shouldShow)
		}
	/*	preferences.edit()
				.putBoolean(KEY_SHOULD_SHOW_ONBOARDING_SCREEN, shouldShow)
				.apply()*/
	}

	//endregion

}