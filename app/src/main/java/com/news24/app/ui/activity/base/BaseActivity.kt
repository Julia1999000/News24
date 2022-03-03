package com.news24.app.ui.activity.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.news24.app.components.AppContext
import com.news24.app.di.AppComponent
import com.news24.app.helpers.KeyboardHelper
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Provider

open class BaseActivity : MvpAppCompatActivity(), BaseScreenContract.View  {

	@InjectPresenter
	lateinit var basePresenter: BaseScreenContract.Presenter

	private lateinit var basePresenterProvider: Provider<BaseScreenContract.Presenter>


	//region ==================== Lifecycle callbacks ====================

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
	}

	//endregion


	//region ==================== Lifecycle ====================

	override fun onPause() {
		super.onPause()
		KeyboardHelper.hideSoftKeyboard(this)
	}

	//endregion


	//region ==================== Options menu ====================

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			android.R.id.home -> {
				finish()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	//endregion


	//region ==================== DI ====================

	fun getAppComponent(): AppComponent {
		return AppContext.instance.appComponent
	}

	private fun configureDI() {
		val component = getAppComponent().plus(BaseScreenModule())
		basePresenterProvider = component.provideBaseScreenPresenter()
	}

	@ProvidePresenter
	internal fun provideBaseScreenPresenter(): BaseScreenContract.Presenter {
		return basePresenterProvider.get()
	}

	//endregion


	//region ==================== Protected ====================

	fun showSnackBar(message: String, actionText: String? = null, action: View.OnClickListener? = null, container: View? = null) {
		val snackBar = Snackbar.make(container ?: window.decorView.findViewById(android.R.id.content),
				message, Snackbar.LENGTH_SHORT)
		if (actionText != null) {
			snackBar.setAction(actionText, action)
			snackBar.duration = Snackbar.LENGTH_INDEFINITE
		}
		try {
			val snackBarView = snackBar.view
			val textView = snackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
			textView.maxLines = 5
		} catch (e: Exception) {
			e.printStackTrace()
		}

		snackBar.show()
	}

	//endregion

}