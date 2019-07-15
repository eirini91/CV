package com.eirinitelevantou.cv.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View
import com.eirinitelevantou.cv.di.component.ActivityComponent
import com.eirinitelevantou.cv.utils.CommonUtils

abstract class BaseFragment : Fragment(), MvpView {

    var baseActivity: BaseActivity? = null
    private var mProgressDialog: ProgressDialog? = null

    override val isNetworkConnected: Boolean
        get() = if (baseActivity != null) {
            baseActivity!!.isNetworkConnected
        } else false

    val activityComponent: ActivityComponent?
        get() = if (baseActivity != null) {
            baseActivity!!.activityComponent
        } else null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = this.context?.let { CommonUtils.showLoadingDialog(it) }
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun onError(message: String) {
        if (baseActivity != null) {
            baseActivity!!.onError(message)
        }
    }

    override fun onError(@StringRes resId: Int) {
        if (baseActivity != null) {
            baseActivity!!.onError(resId)
        }
    }

    override fun showMessage(message: String) {
        if (baseActivity != null) {
            baseActivity!!.showMessage(message)
        }
    }

    override fun showMessage(@StringRes resId: Int) {
        if (baseActivity != null) {
            baseActivity!!.showMessage(resId)
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun hideKeyboard() {
        if (baseActivity != null) {
            baseActivity!!.hideKeyboard()
        }
    }


    protected abstract fun setUp(view: View)


    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}
