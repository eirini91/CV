package com.eirinitelevantou.cv.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.ui.main.MainActivity

import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashMvpView {
    override fun openActivityOnTokenExpire() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    var mPresenter: SplashMvpPresenter<SplashMvpView>? = null
        @Inject set


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activityComponent!!.inject(this)


        mPresenter!!.onAttach(this@SplashActivity)
    }


    override fun openMainActivity() {
        val intent = MainActivity.getStartIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }


    override fun onDestroy() {
        mPresenter!!.onDetach()
        super.onDestroy()
    }

    override fun setUp() {

    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }
}
