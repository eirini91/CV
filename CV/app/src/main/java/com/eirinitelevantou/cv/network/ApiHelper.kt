package com.eirinitelevantou.cv.network

import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.network.model.School
import com.eirinitelevantou.cv.network.model.Skill
import io.reactivex.Single

interface ApiHelper {


    fun doGetJobsApiCall(): Single<List<Job>>

    fun doGetSchoolsApiCall(): Single<List<School>>

    fun doGetSkillsApiCall(): Single<List<Skill>>

}
