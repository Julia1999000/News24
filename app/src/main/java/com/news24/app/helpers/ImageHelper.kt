package com.news24.app.helpers

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.news24.app.ui.other.transformation.RoundedCornersTransformation
import java.io.File

object ImageHelper {

    const val CENTER_CROP = "CENTER_CROP"

    const val CENTER_INSIDE = "CENTER_INSIDE"

    fun loadImageByUrlToImageView(
        url: String,
        imageView: ImageView,
        scaleType: String? = null,
        placeholderResId: Int? = null,
        successAction: () -> Unit = {},
        errorAction: () -> Unit = {}
    ) {
        cancellingLoads(imageView)

        var glideRequest = Glide.with(imageView.context).load(url)
        val scaleTypeTransform = getScaleTypeTransformation(scaleType)
        val requestOptions = RequestOptions()
            .transform(scaleTypeTransform)
            .format(DecodeFormat.PREFER_RGB_565)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .sizeMultiplier(0.75f)

        val requestListener = object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                errorAction()
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                successAction()
                return false
            }
        }

        placeholderResId?.let { glideRequest = glideRequest.placeholder(placeholderResId) }
        glideRequest.apply(requestOptions).addListener(requestListener).into(imageView)
    }

    fun loadImageResourceToImageView(
        imageView: ImageView,
        @DrawableRes imageResId: Int,
        scaleType: String? = null,
        successAction: () -> Unit = {}
    ) {
        cancellingLoads(imageView)

        var glideRequest = Glide.with(imageView.context)
            .load(imageResId)
            .apply(
                RequestOptions()
                    .transform(CenterCrop())
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .optionalCenterInside()
            )

        val scaleTypeTransform = getScaleTypeTransformation(scaleType)
        var requestOptions = RequestOptions()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        requestOptions = requestOptions.transform(scaleTypeTransform)
        glideRequest = glideRequest.apply(requestOptions)

        val requestListener = object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                successAction()
                return false
            }
        }

        glideRequest
            .transition(DrawableTransitionOptions.withCrossFade(250))
            .addListener(requestListener)
            .into(imageView)
    }

    fun loadImageFileToImageView(
        imageView: ImageView,
        imageFile: File,
        scaleType: String? = null,
        successAction: () -> Unit = {}
    ) {
        cancellingLoads(imageView)

        var glideRequest = Glide.with(imageView.context)
            .load(imageFile)
            .apply(
                RequestOptions()
                    .transform(CenterCrop())
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .optionalCenterInside()
            )

        val scaleTypeTransform = getScaleTypeTransformation(scaleType)
        val requestOptions = RequestOptions()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .transform(scaleTypeTransform)

        glideRequest = glideRequest.apply(requestOptions)

        glideRequest
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    successAction()
                    return false
                }
            }).into(imageView)
    }

    fun loadImageWithTypedCornersToImageView(
        url: String,
        imageView: ImageView,
        transformation: RoundedCornersTransformation,
        scaleType: String? = null,
    ) {
        cancellingLoads(imageView)

        val glideRequest = Glide.with(imageView.context).load(url)
        val scaleTypeTransform = getScaleTypeTransformation(scaleType)
        val requestOptions = RequestOptions()
            .transform(scaleTypeTransform, transformation)
            .format(DecodeFormat.PREFER_RGB_565)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .sizeMultiplier(0.75f)

        glideRequest.apply(requestOptions).into(imageView)
    }

    private fun getScaleTypeTransformation(scaleType: String? = null): BitmapTransformation {
        return CenterInside().takeIf { scaleType == CENTER_INSIDE } ?: CenterCrop()
    }

    fun clearResources(imageView: ImageView) {
        Glide.get(imageView.context).requestManagerRetriever.get(imageView.context).clear(imageView)
    }

    fun cancellingLoads(imageView: ImageView) {
        Glide.with(imageView.context).clear(imageView)
    }

}