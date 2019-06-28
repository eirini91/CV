

package com.eirinitelevantou.cv.network

import com.eirinitelevantou.cv.BuildConfig


object ApiEndPoint {

    val ENDPOINT_JOBS = BuildConfig.BASE_URL + "/work.json"

    val ENDPOINT_SCHOOLS = BuildConfig.BASE_URL + "/schools.json"

    val ENDPOINT_SKILLS = BuildConfig.BASE_URL + "/skills.json"

}// This class is not publicly instantiable
