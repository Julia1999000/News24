package com.news24.app.ui.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news24.app.databinding.FragmentOnboardingBinding
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.onboarding.adapter.OnboardingAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class OnboardingScreenFragment : BaseFragment(), OnboardingScreenContract.View {

	@InjectPresenter
	lateinit var presenter: OnboardingScreenContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<OnboardingScreenContract.Presenter>

	//private lateinit var fragmentBinding: FragmentOnboardingBinding
	private val fragmentBinding by lazy { FragmentOnboardingBinding.inflate(layoutInflater) }

	@Inject
	lateinit var adapter: OnboardingAdapter

	//region ==================== Fragment creation ====================

	companion object {
		fun newInstance(): OnboardingScreenFragment {
			val args = Bundle()

			val fragment = OnboardingScreenFragment()
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
		//return inflater.inflate(R.layout.fragment_onboarding, container, false)
		//fragmentBinding = FragmentOnboardingBinding.inflate(inflater, container, false)
		return fragmentBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initUI(view)
	}

	//endregion


	//region ==================== UI handlers ====================

	//endregion


	//region ==================== OnboardingScreenContract.View ====================

	override fun showItemList(items: List<ListViewModel>) {
		adapter.swapItems(items)
	}

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(OnboardingScreenModule(requireActivity()))
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): OnboardingScreenContract.Presenter {
		return presenterProvider.get()
	}

	//endregion


	//region ==================== UI ====================

	private fun initUI(view: View) {
		fragmentBinding.apply {
			slider.adapter = adapter
			slider.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER

			indicatorContainer.setViewPager2(slider)
			btnSkip.setOnClickListener { presenter.onSkipButtonClicked() }
		}
	}

	//endregion

}