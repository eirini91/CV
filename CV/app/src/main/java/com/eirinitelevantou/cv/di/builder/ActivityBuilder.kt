package com.eirinitelevantou.cv.di.builder

import com.eirinitelevantou.cv.ui.main.MainActivity
import com.eirinitelevantou.cv.ui.splash.SplashActivity
import com.eirinitelevantou.cv.ui.splash.SplashActivityModule
import com.pkfcooperparry.template.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])

    internal abstract fun bindSplashActivity(): SplashActivity


    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

}
