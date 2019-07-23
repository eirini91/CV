package com.eirinitelevantou.cv.ui.skills

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class SkillsFragmentModule {

    @Provides
    internal fun provideSkillsFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): SkillsFragmentViewModel {
        return SkillsFragmentViewModel(dataManager, schedulerProvider)
    }
}
