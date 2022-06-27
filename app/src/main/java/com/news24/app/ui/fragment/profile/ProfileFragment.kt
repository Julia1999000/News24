package com.news24.app.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news24.app.databinding.FragmentProfileBinding
import com.news24.app.ui.fragment.base.BaseFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class ProfileFragment : BaseFragment(), ProfileContract.View {

	@InjectPresenter
	lateinit var presenter: ProfileContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<ProfileContract.Presenter>

	private val fragmentBinding by lazy { FragmentProfileBinding.inflate(layoutInflater) }

	//region ==================== Fragment creation ====================

	companion object {
		fun newInstance(): ProfileFragment {
			val args = Bundle()

			val fragment = ProfileFragment()
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


	//region ==================== ProfileContract.View ====================

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(ProfileModule(requireActivity()))
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): ProfileContract.Presenter {
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