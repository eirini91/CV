package com.eirinitelevantou.cv.ui.skills

import com.eirinitelevantou.cv.ui.skills.SkillsFragment
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SkillsFragmentProvider {

    @ContributesAndroidInjector(modules = [SkillsFragmentModule::class])
    internal abstract fun provideSkillsFragmentFactory(): SkillsFragment
}
