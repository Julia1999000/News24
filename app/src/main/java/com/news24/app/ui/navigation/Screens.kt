package com.news24.app.ui.navigation

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.news24.app.ui.activity.container.ContainerScreenActivity
import com.news24.app.ui.activity.main.MainScreenActivity
import com.news24.app.ui.activity.photo.PhotoScreenActivity
import com.news24.app.ui.fragment.detail.article.ArticleFragment
import com.news24.app.ui.fragment.detail.article.model.ArticleScreenParams
import com.news24.app.ui.fragment.detail.broadcast.BroadcastFragment
import com.news24.app.ui.fragment.detail.broadcast.model.BroadcastScreenParams
import com.news24.app.ui.fragment.detail.news.NewsFragment
import com.news24.app.ui.fragment.detail.news.model.NewsScreenParams
import com.news24.app.ui.fragment.detail.photoalbum.PhotoAlbumFragment
import com.news24.app.ui.fragment.detail.photoalbum.model.PhotoAlbumScreenParams
import com.news24.app.ui.fragment.events.EventsFragment
import com.news24.app.ui.fragment.onboarding.OnboardingFragment
import com.news24.app.ui.fragment.photoviewer.PhotoViewerFragment
import com.news24.app.ui.fragment.photoviewer.model.PhotoViewerScreenParams
import com.news24.app.ui.fragment.profile.ProfileFragment
import com.news24.app.ui.fragment.settings.SettingsFragment
import com.news24.app.ui.fragment.webview.WebViewFragment
import com.news24.app.ui.fragment.webview.model.WebViewParams
import kotlinx.parcelize.Parcelize
import ru.terrakok.cicerone.android.support.SupportAppScreen


object Screens {

	class MainContainerScreen : SupportAppScreen() {
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

	class PhotoContainerScreen(private val screen: Parcelable?) : SupportAppScreen() {
		override fun getActivityIntent(context: Context): Intent {
			val intent = Intent(context, PhotoScreenActivity::class.java)
			intent.putExtra(PhotoScreenActivity.EXTRA_START_SCREEN, screen)
			return intent
		}
	}

	@Parcelize
	class OnboardingScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return OnboardingFragment.newInstance()
		}
	}

	@Parcelize
	class EventsScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return EventsFragment.newInstance()
		}
	}

	@Parcelize
	class ProfileScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return ProfileFragment.newInstance()
		}
	}

	@Parcelize
	class SettingsScreen : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return SettingsFragment.newInstance()
		}
	}

	@Parcelize
	class ArticleScreen(val params: ArticleScreenParams) : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return ArticleFragment.newInstance(params)
		}
	}

	@Parcelize
	class WebViewScreen(val params: WebViewParams) : SupportAppScreen(), Parcelable  {
		override fun getFragment(): Fragment {
			return WebViewFragment.newInstance(params)
		}
	}

	@Parcelize
	class NewsScreen(val params: NewsScreenParams) : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return NewsFragment.newInstance(params)
		}
	}

	@Parcelize
	class BroadcastScreen(val params: BroadcastScreenParams) : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return BroadcastFragment.newInstance(params)
		}
	}

	@Parcelize
	class PhotoAlbumScreen(val params: PhotoAlbumScreenParams) : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return PhotoAlbumFragment.newInstance(params)
		}
	}

	@Parcelize
	class PhotoViewerScreen(val params: PhotoViewerScreenParams) : SupportAppScreen(), Parcelable {
		override fun getFragment(): Fragment {
			return PhotoViewerFragment.newInstance(params)
		}
	}

}