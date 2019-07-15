package com.eirinitelevantou.cv.network.remote

import retrofit2.http.GET
import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.network.model.School
import com.eirinitelevantou.cv.network.model.Skill
import com.eirinitelevantou.cv.network.remote.ApiEndPoint
import io.reactivex.Observable


interface ApiHelper {

    @GET(ApiEndPoint.ENDPOINT_JOBS)
    fun getJobs(): Observable<List<Job>>

    @GET(ApiEndPoint.ENDPOINT_SCHOOLS)
    fun getSchools(): Observable<List<School>>

    @GET(ApiEndPoint.ENDPOINT_SKILLS)
    fun getSkills(): Observable<List<Skill>>

}
