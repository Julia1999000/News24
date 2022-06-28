package com.news24.app.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.news24.app.R
import com.news24.app.databinding.ViewStatusBroadcastBinding
import com.news24.app.ui.fragment.events.adapter.broadcast.StatusBroadcast

class StatusBroadcastView : ConstraintLayout {

    private val viewBinding by lazy {
        ViewStatusBroadcastBinding.inflate(LayoutInflater.from(context), this, true)
    }

    var status: StatusBroadcast = StatusBroadcast.START
        set(value) {
            when (value) {
                StatusBroadcast.START -> { showLogoOfStartedBroadcast() }
                StatusBroadcast.END -> { showLogoOfFinishedBroadcast() }
            }
            field = value
        }

    //region ===================== Constructors ======================

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    //endregion


    //region ===================== UI ======================

    private fun init(attrs: AttributeSet?, defStyle: Int) {

    }

    //endregion


    //region ===================== Internal ======================

    private fun showLogoOfFinishedBroadcast() {
        viewBinding.apply {
            tvLiveLogo.setBackgroundResource(R.drawable.background_live_end)
            tvLiveLogo.setTextColor(ContextCompat.getColor(context, R.color.black))
            tvLiveLogoDetails.text = resources.getString(R.string.live_end)
        }
    }

    private fun showLogoOfStartedBroadcast() {
        viewBinding.apply {
            tvLiveLogo.setBackgroundResource(R.drawable.background_live_start)
            tvLiveLogo.setTextColor(ContextCompat.getColor(context, R.color.white))
            tvLiveLogoDetails.text = null
        }
    }

    //endregion

}