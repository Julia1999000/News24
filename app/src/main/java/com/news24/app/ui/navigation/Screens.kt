package com.news24.app.ui.navigation

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.news24.app.ui.activity.container.ContainerScreenActivity
import com.news24.app.ui.activity.main.MainScreenContainerActivity
import com.news24.app.ui.fragment.events.EventsScreenFragment
import com.news24.app.ui.fragment.onboarding.OnboardingScreenFragment
import com.news24.app.ui.fragment.profile.ProfileScreenFragment
import com.news24.app.ui.fragment.settings.SettingsScreenFragment
import kotlinx.parcelize.Parcelize
import ru.terrakok.cicerone.android.support.SupportAppScreen


object Screens {

	class MainContainerScreen : SupportAppScreen() {
		override fun getActivityIntent(context: Context): Intent {
			val intent = Intent(context, MainScreenContainerActivity::class.java)
			intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

			return intent
		}
	}

	class ContainerScreen(private val screen: Parcelable?) : SupportAppScreen() {
		override fun getActivityIntent(context: Context): Intent {
			val intent = Intent(context, ContainerScreenActivity::class.java)
			intent.putExtra(ContainerScreenActivity.EXTRA_START_SCREEN, screen)
			return intent
		}
	}

	@Parcelize
	class OnboardingScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return OnboardingScreenFragment.newInstance()
		}
	}

	@Parcelize
	class EventsScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return EventsScreenFragment.newInstance()
		}
	}

	@Parcelize
	class ProfileScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return ProfileScreenFragment.newInstance()
		}
	}

	@Parcelize
	class SettingsScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return SettingsScreenFragment.newInstance()
		}
	}

}