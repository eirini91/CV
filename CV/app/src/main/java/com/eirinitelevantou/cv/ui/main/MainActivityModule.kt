package com.pkfcooperparry.template.ui.main

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): MainViewModel {
        return MainViewModel(dataManager, schedulerProvider)
    }
}
