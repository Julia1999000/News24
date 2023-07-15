package com.news24.app.ui.fragment.detail.photoalbum

import com.news24.app.R
import com.news24.app.helpers.FormatHelper
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.delegates.separator.SeparatorViewModel
import com.news24.app.ui.adapter.delegates.textview.TextViewModel
import com.news24.app.ui.fragment.detail.photoalbum.adapter.countphotos.CountPhotosViewModel
import com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.groupofphotos.GroupOfPhotosViewModel
import com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.onephoto.OnePhotoViewModel
import com.news24.app.ui.fragment.detail.photoalbum.model.PhotoAlbumScreenParams
import com.news24.app.ui.fragment.photoviewer.model.PhotoViewerScreenParams
import com.news24.app.ui.fragment.webview.model.WebViewParams
import com.news24.app.ui.navigation.Screens
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import java.util.ArrayList
import javax.inject.Inject


@InjectViewState
class PhotoAlbumPresenter @Inject constructor(
        private val router: Router,
        private val params: PhotoAlbumScreenParams
) : PhotoAlbumContract.Presenter() {

    private var heightBottomOffsetDp = 0
    private var viewModels: List<ListViewModel> = emptyList()

    companion object {
        private const val OFFSET_10_DP = 10
        private const val OFFSET_16_DP = 16
        private const val NUMBER_OF_PHOTOS_IN_BLOCK = 5
        private const val NUMBER_OF_PHOTOS_IN_GROUP = 4
        private const val MAX_SPAN_SIZE = 2
        private const val MIN_SPAN_SIZE = 1
        private const val COUNT_PHOTOS_VIEW_MODEL_ID = "COUNT_PHOTOS_VIEW_MODEL_ID"
        private const val GROUP_OF_PHOTOS_VIEW_MODEL_ID = "GROUP_OF_PHOTOS_VIEW_MODEL_ID"
    }

    //region ===================== MVP Presenter ======================

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showBackground(params.backgroundImage)
    }

    //endregion


    //region ==================== PhotoAlbumContract.Presenter ====================

    override fun onListItemClicked(item: ListViewModel) {
        when(item) {
            is OnePhotoViewModel -> {
                router.navigateTo(Screens.PhotoContainerScreen(Screens.PhotoViewerScreen(
                    PhotoViewerScreenParams(params.photoUrlList, item.photoUrl))))
            }
        }
    }

    override fun onBackClicked() {
        router.exit()
    }

    override fun onReadFurtherClicked() {
        router.navigateTo(Screens.WebViewScreen(WebViewParams(params.url)))
    }

    override fun onShareClicked() {
        viewState.sharePhotoAlbum(params.url)
    }

    override fun setOffset(heightBottomPanelDp: Int) {
        heightBottomOffsetDp = heightBottomPanelDp

        viewState.showData(createListViewModel())
    }

    //endregion


    //region ===================== Internal ======================

    private fun createListViewModel(): ArrayList<ListViewModel> {
        val listViewModel = ArrayList<ListViewModel>()
        listViewModel.add(SeparatorViewModel(R.color.transparent, OFFSET_16_DP))
        listViewModel.add(CountPhotosViewModel(COUNT_PHOTOS_VIEW_MODEL_ID, params.photoUrlList.size))
        listViewModel.add(SeparatorViewModel(R.color.transparent, OFFSET_16_DP))
        listViewModel.add(createHeaderViewModel())
        listViewModel.add(createPublishDateViewModel())
        listViewModel.addAll(createPhotosViewModels())
        listViewModel.add(SeparatorViewModel(R.color.transparent, heightBottomOffsetDp))

        viewModels = listViewModel
        return listViewModel
    }

    private fun createHeaderViewModel(): ListViewModel {
        return TextViewModel(
            text = params.title,
            styleId = R.style.S30BoldWhite,
            horizontalPaddingDp = OFFSET_16_DP,
            bottomPaddingDp = OFFSET_10_DP
        )
    }

    private fun createPublishDateViewModel(): ListViewModel {
        return TextViewModel(
            text = FormatHelper.getFormattedTime(params.publishDate),
            styleId = R.style.S14RegularWhite,
            horizontalPaddingDp = OFFSET_16_DP,
            bottomPaddingDp = OFFSET_10_DP
        )
    }

    private fun createPhotosViewModels(): ArrayList<ListViewModel> {
        val listViewModel = ArrayList<ListViewModel>()
        params.photoUrlList.size.let {
            listViewModel.addAll(createBlocksOfPhotoViewModels(it / NUMBER_OF_PHOTOS_IN_BLOCK))
            listViewModel.addAll(createRemainingPhotoViewModels(it % NUMBER_OF_PHOTOS_IN_BLOCK))
        }
        return listViewModel
    }

    private fun createBlocksOfPhotoViewModels(countBlocks: Int): ArrayList<ListViewModel> {
        val listViewModel = ArrayList<ListViewModel>()

        var isReverse = false
        for (i in 0 until countBlocks) {
            if (isReverse) {
                listViewModel.add(createGroupOfPhotosViewModel(GROUP_OF_PHOTOS_VIEW_MODEL_ID + i.toString(),
                    i * NUMBER_OF_PHOTOS_IN_BLOCK))
                listViewModel.add(createOnePhotoViewModel(MIN_SPAN_SIZE,
                    i * NUMBER_OF_PHOTOS_IN_BLOCK + NUMBER_OF_PHOTOS_IN_GROUP))
            } else {
                listViewModel.add(createOnePhotoViewModel(MIN_SPAN_SIZE, i * NUMBER_OF_PHOTOS_IN_BLOCK))
                listViewModel.add(createGroupOfPhotosViewModel(GROUP_OF_PHOTOS_VIEW_MODEL_ID + i.toString(),
                    i * NUMBER_OF_PHOTOS_IN_BLOCK + 1))
            }
            isReverse = !isReverse
        }

        return listViewModel
    }

    private fun createRemainingPhotoViewModels(countRemaining: Int): ArrayList<ListViewModel> {
        val listViewModel = ArrayList<ListViewModel>()
        if (countRemaining > 0) {
            var i = 0
            while (i < countRemaining - 1) {
                (params.photoUrlList.size - countRemaining + i).let { photoId ->
                    listViewModel.add(createOnePhotoViewModel(MIN_SPAN_SIZE, photoId))
                }
                i++
            }
            (params.photoUrlList.lastIndex).let { photoId ->
                listViewModel.add(createOnePhotoViewModel(MIN_SPAN_SIZE.takeIf { countRemaining % 2 == 0 }
                    ?: MAX_SPAN_SIZE, photoId))
            }
        }
        return listViewModel
    }

    private fun createGroupOfPhotosViewModel(viewModelId: String, idOfFirstPhoto: Int): ListViewModel {
        var photoId = idOfFirstPhoto
        return GroupOfPhotosViewModel(
            listItemId = viewModelId,
            spanSize = 1,
            topLeftPhoto = createOnePhotoViewModel(MIN_SPAN_SIZE, photoId++),
            topRightPhoto = createOnePhotoViewModel(MIN_SPAN_SIZE, photoId++),
            bottomLeftPhoto = createOnePhotoViewModel(MIN_SPAN_SIZE, photoId++),
            bottomRightPhoto = createOnePhotoViewModel(MIN_SPAN_SIZE, photoId)
        )
    }

    private fun createOnePhotoViewModel(spanSize: Int, photoId: Int): OnePhotoViewModel {
        return OnePhotoViewModel(params.photoUrlList[photoId],  spanSize, params.photoUrlList[photoId])
    }

    //endregion

}