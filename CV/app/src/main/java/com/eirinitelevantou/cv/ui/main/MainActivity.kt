package com.eirinitelevantou.cv.ui.main

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.ActivityMainBinding
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.utils.Navigator
import com.pkfcooperparry.template.ui.main.MainViewInterface
import com.pkfcooperparry.template.ui.main.MainViewModel
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainViewInterface {
    override fun handleError(message: String) {

    }

    override var viewModel: MainViewModel? = null
        @Inject set

    var navigator: Navigator? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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


    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
