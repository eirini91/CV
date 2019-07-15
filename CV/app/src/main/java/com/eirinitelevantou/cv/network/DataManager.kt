package com.eirinitelevantou.cv.network


import com.eirinitelevantou.cv.network.local.db.DbHelper
import com.eirinitelevantou.cv.data.local.prefs.PreferencesHelper
import com.eirinitelevantou.cv.network.remote.ApiHelper

interface DataManager : DbHelper, PreferencesHelper, ApiHelper {

//    fun setUserAsLoggedOut()
//
//    fun updateApiHeader(userId: Long?, accessToken: String)
//
//    fun updateUserInfo(
//            accessToken: String?,
//            userId: Long?,
//            loggedInMode: LoggedInMode,
//            userName: String?,
//            email: String?,
//            profilePicPath: String?)
//
//    enum class LoggedInMode private constructor(val type: Int) {
//
//        LOGGED_IN_MODE_LOGGED_OUT(0),
//        LOGGED_IN_MODE_SERVER(3)
//    }
}
