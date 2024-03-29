package com.eirinitelevantou.cv.ui.base

import android.annotation.TargetApi
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import com.eirinitelevantou.cv.utils.CommonUtils
import com.eirinitelevantou.cv.utils.NetworkUtils


import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import androidx.fragment.app.Fragment
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.widget.Toolbar
import com.eirinitelevantou.cv.R


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(), BaseFragment.Callback {
    private var mProgressDialog: AlertDialog? = null
    var viewDataBinding: T? = null
        private set
    private var mViewModel: V? = null

    abstract val bindingVariable: Int

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val viewModel: V?

    protected abstract val actionBarTitle: String?

    protected abstract val actionBarType: Int

    val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(this)

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)

        performDataBinding()

        setupActionBar()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }


    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    protected fun setupActionBar() {
        val title = findViewById<TextView>(R.id.title)

        when (actionBarType) {
            KEY_NO_ACTION_BAR -> {
            }
            KEY_BACK_HOME_ACTION_BAR -> {
                setSupportActionBar(findViewById(R.id.toolbar))

                val title = findViewById<TextView>(R.id.title)
                title.text = actionBarTitle

                supportActionBar?.setDisplayHomeAsUpEnabled(true);
                supportActionBar?.setDisplayShowHomeEnabled(true);
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_chevron_left);
            }
            KEY_MAIN_ACTION_BAR -> {
                setTitle(null)

            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        this.mViewModel = if (mViewModel == null) viewModel else mViewModel
        viewDataBinding!!.setVariable(bindingVariable, mViewModel)
        viewDataBinding!!.executePendingBindings()
    }


    fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(com.eirinitelevantou.cv.R.id.fragment_container, fragment!!)
                .commit()
            return true
        }
        return false
    }

    companion object {
        val KEY_NO_ACTION_BAR = 0
        val KEY_BACK_HOME_ACTION_BAR = 1
        val KEY_MAIN_ACTION_BAR = 2
        private val TAG = "BaseActivity"
    }
}

