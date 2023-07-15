package com.news24.app.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout


class TouchLayoutView : FrameLayout {

    //region ===================== Constructor ======================

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    //endregion

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        var motion = ev?.action
        return super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        var motion = ev?.action
        return super.onInterceptTouchEvent(ev)
    }

    //region ===================== Internal ======================

    private fun init(attrs: AttributeSet?, defStyle: Int) {

    }

    //endregion


}