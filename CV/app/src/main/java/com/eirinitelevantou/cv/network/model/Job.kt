package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Job {

    @SerializedName("title")
    @Expose
    private val title: String? = null
    @SerializedName("company")
    @Expose
    private val company: String? = null
    @SerializedName("address")
    @Expose
    private val address: String? = null
    @SerializedName("dates")
    @Expose
    private val dates: String? = null
    @SerializedName("description")
    @Expose
    private val description: String? = null
    @SerializedName("responsibilities")
    @Expose
    private val responsibilities: List<Responsibility>? = null
    @SerializedName("examples")
    @Expose
    private val examples: List<WorkExample>? = null




}