package com.eirinitelevantou.cv.di.module

import android.app.Application
import android.content.Context
import com.eirinitelevantou.cv.di.ApplicationContext
import com.eirinitelevantou.cv.di.PreferenceInfo
import com.eirinitelevantou.cv.network.ApiHelper
import com.eirinitelevantou.cv.network.AppApiHelper
import dagger.Module
import dagger.Provides

import javax.inject.Singleton


@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

}
