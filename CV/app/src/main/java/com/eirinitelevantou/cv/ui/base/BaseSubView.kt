package com.eirinitelevantou.cv.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.support.annotation.StringRes
import android.util.AttributeSet
import android.view.ViewGroup

abstract class BaseSubView : ViewGroup, SubMvpView {

    private var mParentMvpView: MvpView? = null

    override val isNetworkConnected: Boolean
        get() = if (mParentMvpView != null) {
            mParentMvpView!!.isNetworkConnected
        } else false

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @TargetApi(21)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
    }

    override fun attachParentMvpView(mvpView: MvpView) {
        mParentMvpView = mvpView
    }

    override fun showLoading() {
        if (mParentMvpView != null) {
            mParentMvpView!!.showLoading()
        }
    }

    override fun hideLoading() {
        if (mParentMvpView != null) {
            mParentMvpView!!.hideLoading()
        }
    }

    override fun onError(@StringRes resId: Int) {
        if (mParentMvpView != null) {
            mParentMvpView!!.onError(resId)
        }
    }

    override fun onError(message: String) {
        if (mParentMvpView != null) {
            mParentMvpView!!.onError(message)
        }
    }

    override fun showMessage(message: String) {
        if (mParentMvpView != null) {
            mParentMvpView!!.showMessage(message)
        }
    }

    override fun showMessage(@StringRes resId: Int) {
        if (mParentMvpView != null) {
            mParentMvpView!!.showMessage(resId)
        }
    }

    override fun hideKeyboard() {
        if (mParentMvpView != null) {
            mParentMvpView!!.hideKeyboard()
        }
    }

    protected abstract fun bindViewsAndSetOnClickListeners()

    protected abstract fun setUp()
}
