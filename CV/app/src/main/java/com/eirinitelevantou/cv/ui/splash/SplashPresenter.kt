package com.eirinitelevantou.cv.ui.splash

import android.os.Handler
import com.eirinitelevantou.cv.ui.base.BasePresenter
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import io.reactivex.ObservableSource
import io.reactivex.disposables.CompositeDisposable


import javax.inject.Inject


class SplashPresenter<V : SplashMvpView> @Inject
constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V>(schedulerProvider, compositeDisposable), SplashMvpPresenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        Handler().postDelayed({
            getMvpView()!!.openMainActivity()
        }, 3000)

    }


}
