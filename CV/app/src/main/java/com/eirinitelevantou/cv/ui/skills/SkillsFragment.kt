package com.eirinitelevantou.cv.ui.skills

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.FragmentSkillsBinding
import com.eirinitelevantou.cv.ui.base.BaseFragment
import com.eirinitelevantou.cv.utils.Navigator

import javax.inject.Inject

class SkillsFragment : BaseFragment<FragmentSkillsBinding, SkillsFragmentViewModel>(), SkillsFragmentViewInterface {
    var navigator: Navigator? = null
        @Inject set

    var skillsFragmentViewModel: SkillsFragmentViewModel? = null
        @Inject set

    internal var fragmentSkillsStatsBinding: FragmentSkillsBinding? = null
    internal lateinit var linearLayout: LinearLayout

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_skills

    override fun getViewModel(): SkillsFragmentViewModel {
        return this.skillsFragmentViewModel!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { skillsFragmentViewModel!!.setViewInterface(it, this) }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSkillsStatsBinding = viewDataBinding
        linearLayout = view.findViewById(R.id.parent)
        setupUi()

    }

    override fun setupUi() {

    }

    companion object {

        fun newInstance(): SkillsFragment {
            return SkillsFragment()
        }
    }


}
