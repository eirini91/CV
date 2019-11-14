package com.eirinitelevantou.cv.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SkillsResponse{
    @SerializedName("skills")
    @Expose
    public val skills: List<Skill>? = null

}