package com.news24.app.ui.fragment.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news24.app.databinding.FragmentEventsScreenBinding
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.events.adapter.BaseEventViewModel
import com.news24.app.ui.fragment.events.adapter.EventItemOffsetDecoration
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

	@Inject
	lateinit var decoration: EventItemOffsetDecoration

	//region ==================== Fragment creation ====================

	companion object {
		const val EVENTS_COLUMNS_COUNT = 2

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

	private val itemClickListener = object : ListItemClickListener {
		override fun onListItemClicked(delegateViewModel: ListViewModel) {
			presenter.onListItemClicked(delegateViewModel)
		}
	}

	private val onEventsScrollListener = object : RecyclerView.OnScrollListener() {
		override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
			super.onScrolled(recyclerView, dx, dy)

			val layoutManager = fragmentBinding.rvEvents.layoutManager as GridLayoutManager
			val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
			presenter.onListScrolled(lastVisibleItemPosition)
		}
	}

	//endregion


	//region ==================== EventsScreenContract.View ====================

	override fun showData(items: List<ListViewModel>) {
		adapter.swapItems(items)
	}

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(EventsScreenModule(requireActivity(), itemClickListener,
				getParentRouter()))
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
			val gridLayoutManager =  GridLayoutManager(context, EVENTS_COLUMNS_COUNT)
			gridLayoutManager.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
				override fun getSpanSize(position: Int): Int {
					return (adapter.items[position] as? BaseEventViewModel)?.getSpanSize() ?: 0
				}
			}
			rvEvents.addItemDecoration(decoration)
			rvEvents.layoutManager = gridLayoutManager
			rvEvents.adapter = adapter
			rvEvents.addOnScrollListener(onEventsScrollListener)
		}
	}

	//endregion

}