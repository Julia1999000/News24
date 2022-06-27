package com.news24.app.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.news24.app.databinding.ViewEventActionPanelBinding

class EventActionPanelView : ConstraintLayout {

    var listener: EventActionPanelListener? = null

    private val viewBinding by lazy {
        ViewEventActionPanelBinding.inflate(LayoutInflater.from(context), this, true)
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


    //region ===================== Listener ======================

    interface EventActionPanelListener {

        fun onShareClicked()

        fun onReadFurther()

    }

    //endregion


    //region ===================== UI ======================

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        viewBinding.ivShareImg.setOnClickListener { listener?.onShareClicked() }
        viewBinding.tvReadFurther.setOnClickListener { listener?.onReadFurther() }
    }

    //endregion

}