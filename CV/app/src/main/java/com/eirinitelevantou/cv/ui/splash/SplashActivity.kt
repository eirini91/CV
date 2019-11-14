package com.eirinitelevantou.cv.ui.splash

import android.os.Bundle
import android.os.Handler
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.ActivitySplashBinding
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.utils.Navigator

import javax.inject.Inject


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashViewInterface {

    override var viewModel: SplashViewModel? = null
        @Inject set

    var navigator: Navigator? = null
        @Inject set

    override val bindingVariable: Int
        get() = BR.viewModel

    override val actionBarTitle: String?
        get() = null

    override val actionBarType: Int
        get() = BaseActivity.KEY_NO_ACTION_BAR

    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)
        val handler = Handler()
        handler.postDelayed({ viewModel!!.decideNextActivity() }, SPLASH_DISPLAY_LENGTH.toLong())
    }


    override fun openMainActivity() {
        navigator!!.navigateToMainView(this)
        finish()
    }

    companion object {
        private val SPLASH_DISPLAY_LENGTH = 3000
    }
}
