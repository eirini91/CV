package com.eirinitelevantou.cv.ui.splash

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider

class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SplashViewInterface>(dataManager, schedulerProvider) {

    fun decideNextActivity() {
            getViewInterface().openMainActivity()
    }
}


