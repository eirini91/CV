package com.eirinitelevantou.cv.ui.splash


import com.eirinitelevantou.cv.di.PerActivity
import com.eirinitelevantou.cv.ui.base.MvpPresenter

@PerActivity
interface SplashMvpPresenter<V : SplashMvpView> : MvpPresenter<V>
