package com.eirinitelevantou.cv.network.model

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.eirinitelevantou.cv.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Skill(
    @SerializedName("name")
    @Expose val name: String,
    @SerializedName("level")
    @Expose
    val level: String,
    @SerializedName("levelId")
    @Expose
    val levelId: Int,
    @SerializedName("skillId")
    @Expose
    val skillId: Int,
    @SerializedName("icon")
    @Expose
    val icon: String,
    @SerializedName("parent")
    @Expose
    val parent: Boolean,
    @SerializedName("items")
    @Expose
    val items: List<Skill>
){
    fun  getDrawable(): Int{
        when (levelId) {
            1 -> return R.drawable.level_1
            2 -> return R.drawable.level_2
            3 -> return R.drawable.level_3
            4 -> return R.drawable.level_4

            else -> { // Note the block
               return R.drawable.level_1
            }
        }
    }
}