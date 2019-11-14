package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JobsResponse{
    @SerializedName("jobs")
    @Expose
    public val jobs: List<Job>? = null

}