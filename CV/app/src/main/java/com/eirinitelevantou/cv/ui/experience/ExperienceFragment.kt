package com.eirinitelevantou.cv.ui.about

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.FragmentExperienceBinding
import com.eirinitelevantou.cv.ui.base.BaseFragment
import com.eirinitelevantou.cv.utils.Navigator
import com.eirinitelevantou.cv.ui.experience.ExperienceFragmentViewInterface
import com.pkfcooperparry.template.ui.form.page.tab.ExperienceFragmentViewModel

import javax.inject.Inject

class ExperienceFragment : BaseFragment<FragmentExperienceBinding, ExperienceFragmentViewModel>(),
    ExperienceFragmentViewInterface {


    var navigator: Navigator? = null
        @Inject set

    var experienceFragmentViewModel: ExperienceFragmentViewModel? = null
        @Inject set

    internal var fragmentExperienceBinding: FragmentExperienceBinding? = null
    internal lateinit var linearLayout: LinearLayout

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_experience

    override fun getViewModel(): ExperienceFragmentViewModel {
        return this.experienceFragmentViewModel!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { experienceFragmentViewModel!!.setViewInterface(it, this) }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentExperienceBinding = viewDataBinding
        linearLayout = view.findViewById(R.id.parent)
        setupUi()

    }

    override fun setupUi() {

    }

    companion object {

        fun newInstance(): ExperienceFragment {
            return ExperienceFragment()
        }
    }


}
