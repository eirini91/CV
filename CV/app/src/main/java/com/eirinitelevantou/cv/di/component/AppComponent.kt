package com.eirinitelevantou.cv.di.component

import android.app.Application
import com.eirinitelevantou.cv.CVApp
import com.eirinitelevantou.cv.di.builder.ActivityBuilder
import com.eirinitelevantou.cv.di.module.AppModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app: CVApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
