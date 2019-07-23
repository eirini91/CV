package com.eirinitelevantou.cv.ui.about

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import com.eirinitelevantou.cv.ui.school.SchoolFragmentViewModel

import dagger.Module
import dagger.Provides

@Module
class SchoolFragmentModule {

    @Provides
    internal fun provideSchoolFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): SchoolFragmentViewModel {
        return SchoolFragmentViewModel(dataManager, schedulerProvider)
    }
}
