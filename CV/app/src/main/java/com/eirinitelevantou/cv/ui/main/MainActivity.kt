

package com.eirinitelevantou.cv.ui.main

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.eirinitelevantou.cv.BuildConfig
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.ui.splash.SplashMvpPresenter
import com.eirinitelevantou.cv.ui.splash.SplashMvpView
import com.eirinitelevantou.cv.utils.ScreenUtils
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject


class MainActivity : BaseActivity(), MainMvpView {

    var mPresenter: MainMvpPresenter<MainMvpView>? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent?.inject(this)

        mPresenter!!.onAttach(this)

        setUp()
    }

    override fun onBackPressed() {
//        val fragmentManager = supportFragmentManager
//        val fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG)
//        if (fragment == null) {
//            super.onBackPressed()
//        } else {
//            onFragmentDetached(AboutFragment.TAG)
//        }
    }


    override fun updateAppVersion() {
        val version = getString(R.string.version) + " " + BuildConfig.VERSION_NAME
        tv_app_version!!.text = version
    }

    override fun updateUserProfilePic(currentUserProfilePicUrl: String) {
        //load profile pic url into ANImageView
    }

    override fun onResume() {
        super.onResume()
        if (drawer_view != null)
            drawer_view!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun onDestroy() {
        mPresenter!!.onDetach()
        super.onDestroy()
    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .remove(fragment)
                .commitNow()
            unlockDrawer()
        }
    }

    override fun showAboutFragment() {
        lockDrawer()
//        supportFragmentManager
//            .beginTransaction()
//            .disallowAddToBackStack()
//            .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
//            .add(R.id.cl_root_view, AboutFragment.newInstance(), AboutFragment.TAG)
//            .commit()
    }

    override fun lockDrawer() {
        if (drawer_view != null)
            drawer_view!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun unlockDrawer() {
        if (drawer_view != null)
            drawer_view!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val drawable = item.icon
        if (drawable is Animatable) {
            (drawable as Animatable).start()
        }
        when (item.itemId) {
            R.id.action_cut -> return true
            R.id.action_copy -> return true
            R.id.action_share -> return true
            R.id.action_delete -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun setUp() {
        setSupportActionBar(toolbar)
       val mDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_view,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        ) {
            override fun onDrawerOpened(drawerView: View) {
                    super.onDrawerOpened(drawerView)
                hideKeyboard()
            }

            override fun onDrawerClosed(drawerView: View) {
                    super.onDrawerClosed(drawerView)

            }
        }
        drawer_view!!.addDrawerListener(mDrawerToggle!!)
        mDrawerToggle.syncState()
        setupNavMenu()
        mPresenter!!.onNavMenuCreated()
        setupCardContainerView()
        mPresenter!!.onViewInitialized()
    }

    private fun setupCardContainerView() {

        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)


    }

    internal fun setupNavMenu() {
        val headerLayout = navigation_view!!.getHeaderView(0)

        navigation_view!!.setNavigationItemSelectedListener { item ->
            drawer_view!!.closeDrawer(GravityCompat.START)
            when (item.itemId) {
                R.id.nav_item_about -> {
                    mPresenter!!.onDrawerOptionAboutClick()
                    true
                }
                R.id.nav_item_rate_us -> {
                    mPresenter!!.onDrawerRateUsClick()
                    true
                }
                R.id.nav_item_feed -> {
                    mPresenter!!.onDrawerMyFeedClick()
                    true
                }
                R.id.nav_item_logout -> {
                    mPresenter!!.onDrawerOptionLogoutClick()
                    true
                }
                else -> false
            }
        }
    }

    override fun openLoginActivity() {
    }

    override fun showRateUsDialog() {
//        RateUsDialog.newInstance().show(supportFragmentManager)
    }

    override fun openMyFeedActivity() {

    }

    override fun closeNavigationDrawer() {
        if (drawer_view != null) {
            drawer_view!!.closeDrawer(Gravity.START)
        }
    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
