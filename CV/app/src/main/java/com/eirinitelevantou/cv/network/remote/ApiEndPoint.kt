package com.eirinitelevantou.cv.network.remote

import com.eirinitelevantou.cv.BuildConfig


object ApiEndPoint {


   const val ENDPOINT_JOBS = BuildConfig.BASE_URL + "work.json"

    const val ENDPOINT_SCHOOLS = BuildConfig.BASE_URL + "schools.json"

    const  val ENDPOINT_SKILLS = BuildConfig.BASE_URL + "skills.json"
}//This class is not publicly instantiable
