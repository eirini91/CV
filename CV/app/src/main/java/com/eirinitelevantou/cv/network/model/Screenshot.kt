package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Screenshot(
    @SerializedName("name")
    @Expose
    private val name: String? = null
) : Serializable {

}