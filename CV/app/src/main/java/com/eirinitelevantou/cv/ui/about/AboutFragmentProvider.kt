package com.pkfcooperparry.template.ui.form.page.tab

import com.eirinitelevantou.cv.ui.about.AboutFragment
import com.eirinitelevantou.cv.ui.about.AboutFragmentModule
import com.eirinitelevantou.cv.ui.skills.SkillsFragment
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AboutFragmentProvider {

    @ContributesAndroidInjector(modules = [AboutFragmentModule::class])
    internal abstract fun provideAboutFragmentFactory(): AboutFragment
}
