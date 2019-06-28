package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Responsibility {
    @SerializedName("title")
    @Expose
    private val title: String? = null
    @SerializedName("description")
    @Expose
    private val description: String? = null
}