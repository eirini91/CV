package com.eirinitelevantou.cv.network

import com.eirinitelevantou.cv.data.local.prefs.PreferencesHelper
import com.eirinitelevantou.cv.network.remote.ApiHelper
import com.eirinitelevantou.cv.network.local.db.DbHelper
import com.eirinitelevantou.cv.network.model.*
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(
    private val mDbHelper: DbHelper,
    private val mPreferencesHelper: PreferencesHelper,
    private val mApiHelper: ApiHelper
) : DataManager {
    override fun getJobs(): Observable<JobsResponse> {
        return mApiHelper.getJobs()
    }

    override fun getSchools(): Observable<List<School>> {
        return mApiHelper.getSchools()
    }

    override fun getSkills(): Observable<SkillsResponse> {
        return mApiHelper.getSkills()
    }



}
