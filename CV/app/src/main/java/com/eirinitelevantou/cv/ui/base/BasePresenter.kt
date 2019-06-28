package com.eirinitelevantou.cv.ui.base

import android.util.Log
import com.androidnetworking.common.ANConstants
import com.androidnetworking.error.ANError
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject
import javax.net.ssl.HttpsURLConnection

open class BasePresenter<V : MvpView> @Inject
constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) : MvpPresenter<V> {

    private var mvpView: V? = null

    val isViewAttached: Boolean
        get() = mvpView != null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        mvpView = null
    }


    fun getMvpView(): V? {
        return mvpView
    }

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    override fun handleApiError(error: ANError) {

        if (error == null || error.errorBody == null) {
            mvpView!!.onError(R.string.api_default_error)
            return
        }

    }

    class MvpViewNotAttachedException :
        RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")

    companion object {

        private val TAG = "BasePresenter"
    }
}
