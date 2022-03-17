package com.news24.app.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news24.app.databinding.FragmentProfileScreenBinding
import com.news24.app.ui.fragment.base.BaseFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class ProfileScreenFragment : BaseFragment(), ProfileScreenContract.View {

	@InjectPresenter
	lateinit var presenter: ProfileScreenContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<ProfileScreenContract.Presenter>

	private val fragmentBinding by lazy { FragmentProfileScreenBinding.inflate(layoutInflater) }

	//region ==================== Fragment creation ====================

	companion object {
		fun newInstance(): ProfileScreenFragment {
			val args = Bundle()

			val fragment = ProfileScreenFragment()
			fragment.arguments = args

			return fragment
		}
	}

	//endregion


	//region ==================== Lifecycle ====================

	override fun onCreate(savedInstanceState: Bundle?) {
		configureDI()
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		return fragmentBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initUI(view)
	}

	//endregion


	//region ==================== UI handlers ====================

	//endregion


	//region ==================== ProfileScreenContract.View ====================

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(ProfileScreenModule(requireActivity()))
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): ProfileScreenContract.Presenter {
		return presenterProvider.get()
	}

	//endregion


	//region ==================== UI ====================

	private fun initUI(view: View) {
		fragmentBinding.apply {

		}
	}

	//endregion

}