package com.news24.app.ui.fragment.events

import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news24.app.R
import com.news24.app.databinding.FragmentEventsBinding
import com.news24.app.helpers.DimensHelper.dpToPx
import com.news24.app.helpers.SpanTextHelper
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.events.adapter.BaseEventViewModel
import com.news24.app.ui.adapter.ItemDecorator
import com.news24.app.ui.fragment.base.view.FragmentWithPreloader
import com.news24.app.ui.fragment.events.adapter.EventsAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class EventsFragment : BaseFragment(), EventsContract.View, FragmentWithPreloader {

	@InjectPresenter
	lateinit var presenter: EventsContract.Presenter

	@Inject
	lateinit var presenterProvider: Provider<EventsContract.Presenter>

	private val fragmentBinding by lazy { FragmentEventsBinding.inflate(layoutInflater) }

	@Inject
	lateinit var adapter: EventsAdapter

	@Inject
	lateinit var itemDecorator: ItemDecorator

	//region ==================== Fragment creation ====================

	companion object {
		const val EVENTS_COLUMNS_COUNT = 2
		const val EVENT_ITEM_OFFSET_DECORATION_DP = 1

		fun newInstance(): EventsFragment {
			val args = Bundle()

			val fragment = EventsFragment()
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

	private val onEventsSpanSizeProvider = object: GridLayoutManager.SpanSizeLookup() {
		override fun getSpanSize(position: Int): Int {
			return (adapter.items[position] as? BaseEventViewModel)?.getSpanSize() ?: 0
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


	//region ==================== EventsContract.View ====================

	override fun showData(items: List<ListViewModel>) {
		adapter.swapItems(items)
	}

	//endregion


	//region ==================== DI ====================

	private fun configureDI() {
		val component = getAppComponent().plus(EventsModule(requireActivity(), itemClickListener,
				getParentRouter()))
		component.inject(this)
	}

	@ProvidePresenter
	internal fun providePresenter(): EventsContract.Presenter {
		return presenterProvider.get()
	}

	//endregion


	//region ==================== UI ====================

	private fun initUI(view: View) {
		val title = SpanTextHelper.getStylizedSpannableStringBuilder(
			resources.getString(R.string.app_name),
			resources.getString(R.string.span_app_name),
			listOf(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.yellow_29)))
		)
		setupDisappearingToolbar(view, title, null as Int?, null)

		fragmentBinding.apply {
			val gridLayoutManager =  GridLayoutManager(context, EVENTS_COLUMNS_COUNT)
			gridLayoutManager.spanSizeLookup = onEventsSpanSizeProvider
			if (rvEvents.itemDecorationCount < 1) {
				itemDecorator.itemOffset = EVENT_ITEM_OFFSET_DECORATION_DP.dpToPx(requireActivity())
				rvEvents.addItemDecoration(itemDecorator)
			}
			rvEvents.layoutManager = gridLayoutManager
			rvEvents.adapter = adapter
			rvEvents.addOnScrollListener(onEventsScrollListener)
		}
	}

	//endregion

}