package com.eirinitelevantou.cv.di.builder

import com.eirinitelevantou.cv.ui.exampleDetails.ExampleDetailsActivity
import com.eirinitelevantou.cv.ui.jobDetails.JobDetailsActivity
import com.eirinitelevantou.cv.ui.main.MainActivity
import com.eirinitelevantou.cv.ui.school.SchoolFragmentProvider
import com.eirinitelevantou.cv.ui.splash.SplashActivity
import com.eirinitelevantou.cv.ui.splash.SplashActivityModule
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentProvider
import com.pkfcooperparry.template.ui.exampleDetails.ExampleDetailsActivityModule
import com.pkfcooperparry.template.ui.form.page.tab.AboutFragmentProvider
import com.pkfcooperparry.template.ui.form.page.tab.ExperienceFragmentProvider
import com.pkfcooperparry.template.ui.jobDetails.JobDetailsActivityModule
import com.pkfcooperparry.template.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class, SkillsFragmentProvider::class, SchoolFragmentProvider::class, ExperienceFragmentProvider::class, AboutFragmentProvider::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [JobDetailsActivityModule::class])
    internal abstract fun bindJobDetailsActivity(): JobDetailsActivity

    @ContributesAndroidInjector(modules = [ExampleDetailsActivityModule::class])
    internal abstract fun bindExampleDetailsActivity(): ExampleDetailsActivity
}
