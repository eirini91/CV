package com.eirinitelevantou.cv.ui.main

import com.eirinitelevantou.cv.di.PerActivity
import com.eirinitelevantou.cv.ui.base.MvpPresenter

@PerActivity
interface MainMvpPresenter<V : MainMvpView> : MvpPresenter<V> {

    fun onDrawerOptionAboutClick()

    fun onDrawerOptionLogoutClick()

    fun onDrawerRateUsClick()

    fun onDrawerMyFeedClick()

    fun onViewInitialized()

    fun onCardExhausted()

    fun onNavMenuCreated()
}
