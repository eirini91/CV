package com.eirinitelevantou.cv.di.module

import android.app.Application
import android.content.Context
import com.eirinitelevantou.cv.network.AppDataManager
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.network.local.db.AppDbHelper
import com.eirinitelevantou.cv.network.local.db.DbHelper
import com.eirinitelevantou.cv.data.local.prefs.AppPreferencesHelper
import com.eirinitelevantou.cv.data.local.prefs.PreferencesHelper
import com.eirinitelevantou.cv.network.remote.ApiClient
import com.eirinitelevantou.cv.network.remote.ApiHelper
import com.eirinitelevantou.cv.di.PreferenceInfo
import com.eirinitelevantou.cv.utils.AppConstants
import com.eirinitelevantou.cv.utils.Navigator
import com.eirinitelevantou.cv.utils.rx.AppSchedulerProvider
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: ApiClient): ApiHelper {
        return appApiHelper.createService(ApiHelper::class.java)
    }

    @Provides
    @Singleton
    internal fun provideAppDatabase(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    internal fun provideNavigator(): Navigator {
        return Navigator()
    }
    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }


}
