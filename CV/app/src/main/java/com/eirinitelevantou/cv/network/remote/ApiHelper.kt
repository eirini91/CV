package com.eirinitelevantou.cv.network.remote

import com.eirinitelevantou.cv.network.model.*
import retrofit2.http.GET
import com.eirinitelevantou.cv.network.remote.ApiEndPoint
import io.reactivex.Observable


interface ApiHelper {

    @GET(ApiEndPoint.ENDPOINT_JOBS)
    fun getJobs(): Observable<JobsResponse>

    @GET(ApiEndPoint.ENDPOINT_SCHOOLS)
    fun getSchools(): Observable<List<School>>

    @GET(ApiEndPoint.ENDPOINT_SKILLS)
    fun getSkills(): Observable<SkillsResponse>

}
