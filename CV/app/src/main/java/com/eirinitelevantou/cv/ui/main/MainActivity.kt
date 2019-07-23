package com.eirinitelevantou.cv.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.ActivityMainBinding
import com.eirinitelevantou.cv.ui.about.AboutFragment
import com.eirinitelevantou.cv.ui.about.ExperienceFragment
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.ui.school.SchoolFragment
import com.eirinitelevantou.cv.ui.skills.SkillsFragment
import com.eirinitelevantou.cv.utils.Navigator
import com.pkfcooperparry.template.ui.main.MainViewInterface
import com.pkfcooperparry.template.ui.main.MainViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainViewInterface, HasSupportFragmentInjector,BottomNavigationView.OnNavigationItemSelectedListener  {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var fragment: Fragment? = null

        when (p0.getItemId()) {
           R.id.action_about -> {fragment = AboutFragment.newInstance()}

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
        setContentView(R.layout.activity_main)
        setUp()
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
