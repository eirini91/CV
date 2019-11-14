package com.pkfcooperparry.template.ui.jobDetails

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class JobDetailsActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): JobDetailsViewModel {
        return JobDetailsViewModel(dataManager, schedulerProvider)
    }
}
