package com.news24.app.ui.fragment.detail.news

import com.news24.app.R
import com.news24.app.data.entities.events.model.ContentType
import com.news24.app.helpers.FormatHelper
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.delegates.separator.SeparatorViewModel
import com.news24.app.ui.adapter.delegates.textview.TextViewModel
import com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.TagsContainerViewModel
import com.news24.app.ui.fragment.detail.news.model.NewsScreenParams
import com.news24.app.ui.fragment.webview.model.WebViewParams
import com.news24.app.ui.navigation.Screens
import com.news24.app.ui.other.device.DeviceProvider
import com.news24.app.ui.other.resources.ResourceProvider
import ru.terrakok.cicerone.Router
import java.util.ArrayList
import javax.inject.Inject


class NewsPresenter @Inject constructor(
        private val router: Router,
        private val params: NewsScreenParams,
        private val deviceProvider: DeviceProvider
): NewsContract.Presenter() {

    private var headerViewModelHeightDp = 0
    private var backgroundHeightDp = 0
    private var viewModels: List<ListViewModel> = emptyList()

    companion object {
        private const val OFFSET_10_DP = 10
        private const val OFFSET_16_DP = 16
        private const val TAGS_VIEW_MODEL_ID = "TAGS_VIEW_MODEL_ID"
        private const val PERCENT_TAG_HEIGHT = 0.095F
    }

    //region ===================== MVP Presenter ======================

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showBackground(params.image ?: params.backgroundImage)
        viewState.setTestHeader(params.title)
    }

    //endregion


    //region ==================== NewsContract.Presenter ====================

    override fun onBackClicked() {
        router.exit()
    }

    override fun onReadFurtherClicked() {
        router.navigateTo(Screens.WebViewScreen(WebViewParams(params.url)))
    }

    override fun onShareClicked() {
        viewState.shareNews(params.url)
    }

    override fun setOffset(heightHeaderDp: Int, heightBackDp: Int) {
        headerViewModelHeightDp = heightHeaderDp
        backgroundHeightDp = heightBackDp

        viewState.showData(createListViewModel())
    }

    //endregion


    //region ===================== Internal ======================

    private fun createListViewModel(): ArrayList<ListViewModel> {
        val listViewModel = ArrayList<ListViewModel>()
        val tagsContainerHeightDp = deviceProvider.getHeightScreenDp() * PERCENT_TAG_HEIGHT
        val emptyViewHeightDp = backgroundHeightDp - headerViewModelHeightDp - tagsContainerHeightDp

        listViewModel.add(SeparatorViewModel(R.color.transparent, emptyViewHeightDp.toInt()))
        listViewModel.add(TagsContainerViewModel(TAGS_VIEW_MODEL_ID, params.tags, tagsContainerHeightDp.toInt()))
        listViewModel.add(createHeaderViewModel())
        listViewModel.add(createPublishDateViewModel())
        listViewModel.addAll(createListContentViewModel())

        viewModels = listViewModel
        return listViewModel
    }


    private fun createListContentViewModel(): ArrayList<ListViewModel> {
        val listViewModel = ArrayList<ListViewModel>()
        params.content.forEach { item ->
            listViewModel.add(SeparatorViewModel(R.color.black, OFFSET_10_DP))
            listViewModel.add(createTextContent(item.content, item.type))
        }

        return listViewModel
    }

    private fun createHeaderViewModel(): ListViewModel {
        return TextViewModel(
            text = params.title,
            styleId = R.style.S36BoldWhite,
            horizontalPaddingDp = OFFSET_16_DP,
            backgroundId = R.drawable.gradient_transparent_to_black,
            bottomPaddingDp = OFFSET_10_DP
        )
    }

    private fun createPublishDateViewModel(): ListViewModel {
        return TextViewModel(
            text = FormatHelper.getFormattedTime(params.publishDate),
            styleId = R.style.S14RegularWhite,
            horizontalPaddingDp = OFFSET_16_DP,
            backgroundId = R.color.black
        )
    }

    private fun createTextContent(text: String, type: ContentType): TextViewModel {
        return TextViewModel(
            text = text,
            styleId = R.style.S18SemiBoldWhite.takeIf { type == ContentType.HEADER }
                ?: R.style.S16RegularWhite,
            horizontalPaddingDp = OFFSET_16_DP,
            backgroundId = R.color.black
        )
    }

    //endregion

}