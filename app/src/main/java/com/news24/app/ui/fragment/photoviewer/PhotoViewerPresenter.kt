package com.news24.app.ui.fragment.photoviewer

import com.news24.app.ui.fragment.photoviewer.adapter.PhotoViewModel
import com.news24.app.ui.fragment.photoviewer.model.PhotoViewerScreenParams
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import java.util.ArrayList
import javax.inject.Inject


@InjectViewState
class PhotoViewerPresenter @Inject constructor(
        private val router: Router,
        private val params: PhotoViewerScreenParams
): PhotoViewerContract.Presenter() {


    //region ===================== MVP Presenter ======================

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        showItemList()
    }

    //endregion


    //region ==================== PhotoAlbumContract.Presenter ====================

    override fun onBackClicked() {
        router.exit()
    }

    //endregion


    //region ===================== Internal ======================

    private fun showItemList() {
        val listViewModel = ArrayList<PhotoViewModel>()

        params.urlList.forEach {
            listViewModel.add(PhotoViewModel(it, it))
        }
        viewState.showItemList(listViewModel)
        val selectedPos = params.urlList.indexOf(params.selectedUrl).takeIf { it >= 0 } ?: 0
        viewState.setCurrentItem(selectedPos)
    }

    //endregion
}