package com.news24.app.ui.fragment.photoviewer.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.news24.app.databinding.ListItemPhotoViewerPageBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.ImageHelper
import javax.inject.Inject
import javax.inject.Named


class PhotoPagerAdapter @Inject constructor(
        @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
) : androidx.viewpager.widget.PagerAdapter() {

    var viewModels: List<PhotoViewModel> = emptyList()

    val layoutInflater: LayoutInflater = LayoutInflater.from(context)


    //region ===================== Override ======================

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = viewModels[position]

        //val itemView = layoutInflater.inflate(R.layout.list_item_photo_viewer_page, container, false)
        val itemBinding = ListItemPhotoViewerPageBinding.inflate(layoutInflater, container, false)

        Glide.with(context)
            .asBitmap()
            .load(item.url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    itemBinding.apply {
                        ImageHelper.loadImageByUrlToImageView(item.url, ivPhoto, ImageHelper.CENTER_INSIDE)
                        /*ivPhoto.setImageBitmap(resource)
                        val displayMetrics = context.resources.displayMetrics
                        val scale = max(resource.width / (displayMetrics.widthPixels.toFloat() / displayMetrics.density),
                            resource.height / (displayMetrics.heightPixels.toFloat() / displayMetrics.density))

                        if (scale < 1) {
                            ivPhoto.setZoomable(false)
                        } else {
                            ivPhoto.setZoomable(true)
                            ivPhoto.maximumScale = (1f + scale)
                            ivPhoto.mediumScale = (1f + scale / 2)
                            ivPhoto.minimumScale = 1f
                        }*/
                    }
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })
        container.addView(itemBinding.root)
        return itemBinding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return viewModels.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
    //endregion


    //region ===================== Public ======================

    fun swapItems(items: List<PhotoViewModel>) {
        this.viewModels = items
        notifyDataSetChanged()
    }

    //endregion


    //region ===================== Internal ======================

    //endregion

}