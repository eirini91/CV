package com.pkfcooperparry.template.ui.main

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider

class MainViewModel internal constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainViewInterface>(dataManager, schedulerProvider)
