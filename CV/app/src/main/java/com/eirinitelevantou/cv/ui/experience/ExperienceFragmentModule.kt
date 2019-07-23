package com.eirinitelevantou.cv.ui.about

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentViewModel
import com.pkfcooperparry.template.ui.form.page.tab.ExperienceFragmentViewModel

import dagger.Module
import dagger.Provides

@Module
class ExperienceFragmentModule {

    @Provides
    internal fun provideExperienceFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): ExperienceFragmentViewModel {
        return ExperienceFragmentViewModel(dataManager, schedulerProvider)
    }
}
