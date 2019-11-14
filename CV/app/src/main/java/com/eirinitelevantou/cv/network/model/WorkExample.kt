package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class WorkExample(
    @SerializedName("title")
    @Expose
     val title: String? = null,
    @SerializedName("description")
    @Expose
     val description: String? = null,
    @SerializedName("link")
    @Expose
     val link: String? = null,
    @SerializedName("screenshots")
    @Expose
     val screenshots: List<String>? = null,
    @SerializedName("technologies")
    @Expose
    val technologies: List<Int>? = null
) : Serializable {

}