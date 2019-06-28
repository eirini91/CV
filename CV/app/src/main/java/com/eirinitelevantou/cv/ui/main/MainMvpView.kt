

package com.eirinitelevantou.cv.ui.main

import com.eirinitelevantou.cv.ui.base.MvpView

interface MainMvpView : MvpView {

    fun openLoginActivity()

    fun showAboutFragment()

    fun updateUserProfilePic(currentUserProfilePicUrl: String)

    fun updateAppVersion()

    fun showRateUsDialog()

    fun openMyFeedActivity()

    fun closeNavigationDrawer()

    fun lockDrawer()

    fun unlockDrawer()
}
