package com.eirinitelevantou.cv.ui.school

import com.eirinitelevantou.cv.ui.about.SchoolFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SchoolFragmentProvider {

    @ContributesAndroidInjector(modules = [SchoolFragmentModule::class])
    internal abstract fun provideSchoolFragmentFactory(): SchoolFragment
}
