package com.pkfcooperparry.template.ui.form.page.tab

import com.eirinitelevantou.cv.ui.about.ExperienceFragment
import com.eirinitelevantou.cv.ui.about.ExperienceFragmentModule
import com.eirinitelevantou.cv.ui.skills.SkillsFragment
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ExperienceFragmentProvider {

    @ContributesAndroidInjector(modules = [ExperienceFragmentModule::class])
    internal abstract fun provideExperienceFragmentFactory(): ExperienceFragment
}
