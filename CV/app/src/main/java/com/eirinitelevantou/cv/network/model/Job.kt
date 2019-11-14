package com.eirinitelevantou.cv.network.model

import androidx.databinding.BaseObservable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Job(
    @SerializedName("title")
    @Expose val title: String,
    @SerializedName("company")
    @Expose
    val company: String,
    @SerializedName("address")
    @Expose
    val address: String,
    @SerializedName("dates")
    @Expose
    val dates: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("icon")
    @Expose
    val icon: String,
    @SerializedName("responsibilities")
    @Expose
    val responsibilities: List<Responsibility>,
    @SerializedName("examples")
    @Expose
    val examples: List<WorkExample>
) : Serializable, BaseObservable() {}