package com.eirinitelevantou.cv.di.component

import com.eirinitelevantou.cv.di.PerActivity
import com.eirinitelevantou.cv.di.module.ActivityModule
import com.eirinitelevantou.cv.ui.main.MainActivity
import com.eirinitelevantou.cv.ui.splash.SplashActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)

}
