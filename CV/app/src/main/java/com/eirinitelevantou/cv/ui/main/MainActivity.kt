package com.eirinitelevantou.cv.ui.main

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.databinding.ActivityMainBinding
import com.eirinitelevantou.cv.ui.about.AboutFragment
import com.eirinitelevantou.cv.ui.about.ExperienceFragment
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.ui.school.SchoolFragment
import com.eirinitelevantou.cv.ui.skills.SkillsFragment
import com.eirinitelevantou.cv.utils.Navigator
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.pkfcooperparry.template.ui.main.MainViewInterface
import com.pkfcooperparry.template.ui.main.MainViewModel
import android.widget.Toast
import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.view.Window
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.utils.CopyCVHelper


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainViewInterface,
    HasSupportFragmentInjector, BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var fragment: Fragment? = null

        when (p0.getItemId()) {
            R.id.action_about -> {
                fragment = AboutFragment.newInstance()
            }

            R.id.action_schools -> fragment = SchoolFragment.newInstance()

            R.id.action_experiences -> fragment = ExperienceFragment.newInstance()

            R.id.action_skills -> fragment = SkillsFragment.newInstance()
        }

        return loadFragment(fragment)
    }

    var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null
        @Inject set

    override fun handleError(message: String) {

    }

    override var viewModel: MainViewModel? = null
        @Inject set

    var navigator: Navigator? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)

        setContentView(R.layout.activity_main)
        setUp()
        createNotificationChannel()
    }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val actionBarTitle: String?
        get() = null

    override val actionBarType: Int
        get() = BaseActivity.KEY_MAIN_ACTION_BAR

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onFragmentAttached() {}

    fun setUp() {
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
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        drawer_view.addDrawerListener(mDrawerToggle)

        loadFragment(AboutFragment.newInstance())

        bottom_navigation.setOnNavigationItemSelectedListener(this)
        navigation_view.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.nav_item_contact -> showContactDialog()
                R.id.nav_item_download -> downloadFile(false)
                R.id.nav_item_download_email -> downloadFile(true)
                R.id.nav_item_info -> showInfoDialog()
                else -> return@OnNavigationItemSelectedListener true
            }


            true
        });

    }

    fun downloadFile(email: Boolean){
// Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                Toast.makeText(this,"We need access to external storage to save the CV",Toast.LENGTH_SHORT).show()
            } else {

                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    if (email) 100 else 200)
            }
        } else {
            CopyCVHelper.copyCV(this,email)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                         permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            100 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    CopyCVHelper.copyCV(this, false)
                }
                return
            }
            200 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    CopyCVHelper.copyCV(this, true)
                }
                return
            }
        }
    }

    fun showInfoDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_app_info)
        val dialogButton = dialog.findViewById(R.id.btn_okay) as Button
        dialogButton.setOnClickListener(View.OnClickListener { dialog.dismiss() })
        dialog.show()
    }

    fun showContactDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_contact)
        val dialogButton = dialog.findViewById(R.id.btn_okay) as Button
        dialogButton.setOnClickListener(View.OnClickListener { dialog.dismiss() })
        dialog.show()
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.notification_channel_name)
            val descriptionText = getString(R.string.notification_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(getString(R.string.notification_channel_id), name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }


    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
