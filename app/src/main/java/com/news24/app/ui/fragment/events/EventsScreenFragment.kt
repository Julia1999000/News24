package com.news24.app.ui.fragment.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news24.app.databinding.FragmentEventsScreenBinding
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.events.adapter.EventsAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class EventsScreenFragment : BaseFragment(), EventsScreenContract.View {

	@InjectPresenter
	lateinit var presenter: EventsScreenContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<EventsScreenContract.Presenter>

	private val fragmentBinding by lazy { FragmentEventsScreenBinding.inflate(layoutInflater) }

	@Inject
	lateinit var adapter: EventsAdapter

	//region ==================== Fragment creation ====================

	companion object {
		fun newInstance(): EventsScreenFragment {
			val args = Bundle()

			val fragment = EventsScreenFragment()
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


	//region ==================== EventsScreenContract.View ====================

	override fun showItemList(items: List<ListViewModel>) {
		adapter.swapItems(items)
	}

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(EventsScreenModule(requireActivity()))
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): EventsScreenContract.Presenter {
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