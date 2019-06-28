package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class School {

    @SerializedName("title")
    @Expose
    private val title: String? = null
    @SerializedName("university")
    @Expose
    private val university: String? = null
    @SerializedName("grade")
    @Expose
    private val grade: String? = null
    @SerializedName("type")
    @Expose
    private val type: String? = null
    @SerializedName("graduation_year")
    @Expose
    private val graduationYear: String? = null
    @SerializedName("logo")
    @Expose
    private val logo: String? = null
}