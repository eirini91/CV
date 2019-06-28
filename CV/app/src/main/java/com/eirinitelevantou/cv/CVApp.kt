package com.eirinitelevantou.cv

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.eirinitelevantou.cv.di.component.ApplicationComponent
import com.eirinitelevantou.cv.di.component.DaggerApplicationComponent
import com.eirinitelevantou.cv.di.module.ApplicationModule

class CVApp : Application() {


    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()

        mApplicationComponent!!.inject(this)

        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }

    }

    fun getComponent(): ApplicationComponent? {
        return mApplicationComponent
    }


    // Needed to replace the component with a test specific one
    fun setComponent(applicationComponent: ApplicationComponent) {
        mApplicationComponent = applicationComponent
    }
}