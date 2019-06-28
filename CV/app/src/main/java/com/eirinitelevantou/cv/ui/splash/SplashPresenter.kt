package com.eirinitelevantou.cv.ui.splash

import com.eirinitelevantou.cv.ui.base.BasePresenter
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import io.reactivex.ObservableSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function

import javax.inject.Inject


class SplashPresenter<V : SplashMvpView> @Inject
constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V>(schedulerProvider, compositeDisposable), SplashMvpPresenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

        getMvpView()!!.openMainActivity()

    }


}
