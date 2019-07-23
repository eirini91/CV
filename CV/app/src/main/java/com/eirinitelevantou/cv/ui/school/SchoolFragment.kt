package com.eirinitelevantou.cv.ui.school

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.FragmentSchoolBinding
import com.eirinitelevantou.cv.ui.skills.SkillsFragment
import com.eirinitelevantou.cv.ui.base.BaseFragment
import com.eirinitelevantou.cv.utils.Navigator

import javax.inject.Inject

class SchoolFragment : BaseFragment<FragmentSchoolBinding, SchoolFragmentViewModel>(), SchoolFragmentViewInterface {
    var navigator: Navigator? = null
        @Inject set

    var schoolFragmentViewModel: SchoolFragmentViewModel? = null
        @Inject set

    internal var fragmentSchoolBinding:   FragmentSchoolBinding? = null
    internal lateinit var linearLayout: LinearLayout

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_school

    override fun getViewModel(): SchoolFragmentViewModel {
        return this.schoolFragmentViewModel!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { schoolFragmentViewModel!!.setViewInterface(it, this) }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSchoolBinding = viewDataBinding
        linearLayout = view.findViewById(R.id.parent)
        setupUi()

    }

    override fun setupUi() {

    }

    companion object {

        fun newInstance(): SchoolFragment {
            return SchoolFragment()
        }
    }


}
