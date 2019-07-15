package com.eirinitelevantou.cv.data.local.prefs

import android.content.Context
import android.content.SharedPreferences

import com.eirinitelevantou.cv.di.PreferenceInfo

import javax.inject.Inject



class AppPreferencesHelper @Inject
constructor(context: Context, @PreferenceInfo prefFileName: String) : PreferencesHelper {

    private val mPrefs: SharedPreferences


    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }


    companion object {

        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }


}
