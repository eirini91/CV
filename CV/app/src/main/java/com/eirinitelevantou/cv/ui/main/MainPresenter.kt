package com.eirinitelevantou.cv.ui.main

import com.eirinitelevantou.cv.ui.base.BasePresenter
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject


class MainPresenter<V : MainMvpView> @Inject
constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V>(schedulerProvider, compositeDisposable), MainMvpPresenter<V> {
    override fun onCardExhausted() {
    }

    override fun onDrawerOptionAboutClick() {
        getMvpView()?.closeNavigationDrawer()
        getMvpView()?.showAboutFragment()
    }

    override fun onDrawerOptionLogoutClick() {
        getMvpView()?.showLoading()


    }

    override fun onViewInitialized() {

    }


    override fun onNavMenuCreated() {
        if (!isViewAttached) {
            return
        }
        getMvpView()?.updateAppVersion()


    }

    override fun onDrawerRateUsClick() {
        getMvpView()?.closeNavigationDrawer()
        getMvpView()?.showRateUsDialog()
    }

    override fun onDrawerMyFeedClick() {
        getMvpView()?.closeNavigationDrawer()
        getMvpView()?.openMyFeedActivity()
    }

    companion object {

        private val TAG = "MainPresenter"
    }
}
