package com.eirinitelevantou.cv.di.component

import android.app.Application
import android.content.Context
import com.eirinitelevantou.cv.CVApp
import com.eirinitelevantou.cv.di.ApplicationContext
import com.eirinitelevantou.cv.di.module.ApplicationModule
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: CVApp)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

}