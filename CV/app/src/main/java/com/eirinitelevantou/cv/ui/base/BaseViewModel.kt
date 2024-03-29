package com.eirinitelevantou.cv.ui.base

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.NetworkUtils
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val isLoading = ObservableBoolean(false)

    val compositeDisposable: CompositeDisposable

    var viewInterface: WeakReference<N>? = null

    var context: Context? = null

    protected val isInternetConnectionValid: Boolean?
        get() = context?.let { NetworkUtils.isNetworkConnected(it) }


    init {
        this.compositeDisposable = CompositeDisposable()
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun getIsLoading(): Boolean {
        return isLoading.get()
    }

    fun getViewInterface(): N {
        return viewInterface!!.get()!!
    }

    open fun setViewInterface(context: Context, navigator: N) {
        this.context = context
        this.viewInterface = WeakReference(navigator)
    }

    protected fun getHumanReadableError(throwable: Any): String {

        val toReturn = "Unknown Error. Please try again..."

        if (throwable is HttpException) {
            when (throwable.code()) {
                404 -> {

                }
            }
        }

        return toReturn
    }


}
