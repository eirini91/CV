package com.pkfcooperparry.template.ui.exampleDetails

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class ExampleDetailsActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): ExampleDetailsViewModel {
        return ExampleDetailsViewModel(dataManager, schedulerProvider)
    }
}
