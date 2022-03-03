package com.news24.app.ui.navigation

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.news24.app.ui.activity.container.ContainerScreenActivity
import com.news24.app.ui.activity.main.MainScreenActivity
import com.news24.app.ui.fragment.onboarding.OnboardingScreenFragment
import kotlinx.parcelize.Parcelize
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

	class MainScreen : SupportAppScreen() {
		override fun getActivityIntent(context: Context): Intent {
			val intent = Intent(context, MainScreenActivity::class.java)
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

}