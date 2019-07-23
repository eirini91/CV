package com.eirinitelevantou.cv.ui.about

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentViewModel
import com.pkfcooperparry.template.ui.form.page.tab.AboutFragmentViewModel

import dagger.Module
import dagger.Provides

@Module
class AboutFragmentModule {

    @Provides
    internal fun provideAboutFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): AboutFragmentViewModel {
        return AboutFragmentViewModel(dataManager, schedulerProvider)
    }
}
