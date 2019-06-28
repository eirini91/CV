package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class WorkExample {
    @SerializedName("title")
    @Expose
    private val title: String? = null
    @SerializedName("description")
    @Expose
    private val description: String? = null
    @SerializedName("link")
    @Expose
    private val link: String? = null
    @SerializedName("screenshots")
    @Expose
    private val screenshots: List<Screenshot>? = null
}