package com.news24.app.helpers

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
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
			errorAction: () -> Unit = {})
	{
		Glide.with(imageView.context).clear(imageView)

		val scaleTypeTransform = if (scaleType == CENTER_INSIDE) {
			CenterInside()
		} else {
			CenterCrop()
		}

		var glideRequest = Glide.with(imageView.context).load(url)

		placeholderResId?.let {
			glideRequest = glideRequest.placeholder(placeholderResId)
		}

		glideRequest
				.apply(RequestOptions()
						.apply { transform(scaleTypeTransform) }
						.format(DecodeFormat.PREFER_RGB_565)
						.diskCacheStrategy(DiskCacheStrategy.DATA)
						.sizeMultiplier(0.75f))
				.addListener(object : RequestListener<Drawable> {
					override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
						errorAction()
						return true
					}

					override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
						successAction()
						return false
					}
				})
				.into(imageView)
	}

	fun loadImageResourceToImageView(
			imageView: ImageView,
			@DrawableRes imageResId: Int,
			scaleType: String? = null,
			successAction: () -> Unit = {})
	{
		Glide.with(imageView.context).clear(imageView)

		var glideRequest = Glide.with(imageView.context)
				.load(imageResId)
				.apply(RequestOptions()
						.transform(CenterCrop())
						.format(DecodeFormat.PREFER_ARGB_8888)
						.diskCacheStrategy(DiskCacheStrategy.NONE)
						.optionalCenterInside()
				)

		val scaleTypeTransform = if (scaleType == CENTER_INSIDE) {
			CenterInside()
		} else {
			CenterCrop()
		}

		var requestOptions = RequestOptions()
				.format(DecodeFormat.PREFER_ARGB_8888)
				.diskCacheStrategy(DiskCacheStrategy.NONE)

		requestOptions = requestOptions.transform(scaleTypeTransform)
		glideRequest = glideRequest.apply(requestOptions)

		glideRequest
				.transition(DrawableTransitionOptions.withCrossFade(250))
				.addListener(object : RequestListener<Drawable> {
					override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
						return true
					}

					override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
						successAction()
						return false
					}
				}).into(imageView)
	}

	fun loadImageFileToImageView(imageView: ImageView,
	                             imageFile: File,
	                             scaleType: String? = null,
	                             successAction: () -> Unit = {}) {
		Glide.with(imageView.context).clear(imageView)

		var glideRequest = Glide.with(imageView.context)
				.load(imageFile)
				.apply(RequestOptions()
						.transform(CenterCrop())
						.format(DecodeFormat.PREFER_ARGB_8888)
						.diskCacheStrategy(DiskCacheStrategy.NONE)
						.optionalCenterInside()
				)

		val scaleTypeTransform = if (scaleType == CENTER_INSIDE) {
			CenterInside()
		} else {
			CenterCrop()
		}

		var requestOptions = RequestOptions()
				.format(DecodeFormat.PREFER_ARGB_8888)
				.diskCacheStrategy(DiskCacheStrategy.NONE)

		requestOptions = requestOptions.transform(scaleTypeTransform)
		glideRequest = glideRequest.apply(requestOptions)

		glideRequest
				.addListener(object : RequestListener<Drawable> {
					override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
						return true
					}

					override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
						successAction()
						return false
					}
				}).into(imageView)
	}

}