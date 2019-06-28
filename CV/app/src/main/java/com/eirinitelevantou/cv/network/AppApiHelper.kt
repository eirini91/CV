package com.eirinitelevantou.cv.network

import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.network.model.School
import com.eirinitelevantou.cv.network.model.Skill
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject
constructor() : ApiHelper {

    override fun doGetJobsApiCall(): Single<List<Job>> {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_JOBS)
            .build()
            .getObjectListSingle(Job::class.java)
    }

    override fun doGetSchoolsApiCall(): Single<List<School>> {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SCHOOLS)
            .build()
            .getObjectListSingle(School::class.java)
    }

    override fun doGetSkillsApiCall(): Single<List<Skill>> {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SKILLS)
            .build()
            .getObjectListSingle(Skill::class.java)
    }


}

