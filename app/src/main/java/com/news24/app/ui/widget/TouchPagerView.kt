package com.news24.app.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


class TouchPagerView : ViewPager {

    //region ===================== Constructor ======================

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
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