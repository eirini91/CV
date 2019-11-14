package com.eirinitelevantou.cv.ui.about

import android.os.Bundle
import android.view.View
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.FragmentAboutBinding
import com.eirinitelevantou.cv.ui.base.BaseFragment
import com.eirinitelevantou.cv.utils.Navigator
import com.pkfcooperparry.template.ui.form.page.tab.AboutFragmentViewInterface
import com.pkfcooperparry.template.ui.form.page.tab.AboutFragmentViewModel

import javax.inject.Inject
import android.text.method.ScrollingMovementMethod
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import kotlinx.android.synthetic.main.fragment_about.*


class AboutFragment : BaseFragment<FragmentAboutBinding, AboutFragmentViewModel>(), AboutFragmentViewInterface {
    var navigator: Navigator? = null
        @Inject set

    var aboutFragmentViewModel: AboutFragmentViewModel? = null
        @Inject set

    internal var fragmentSkillsBinding: FragmentAboutBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = com.eirinitelevantou.cv.R.layout.fragment_about

    override fun getViewModel(): AboutFragmentViewModel {
        return this.aboutFragmentViewModel!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { aboutFragmentViewModel!!.setViewInterface(it, this) }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSkillsBinding = viewDataBinding
        setupUi()

    }

    override fun setupUi() {
        professionalSummary.setMovementMethod(ScrollingMovementMethod())


    }

    companion object {

        fun newInstance(): AboutFragment {
            return AboutFragment()
        }
    }


}
