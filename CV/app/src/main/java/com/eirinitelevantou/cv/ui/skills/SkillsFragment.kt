package com.eirinitelevantou.cv.ui.skills

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.FragmentSkillsBinding
import com.eirinitelevantou.cv.network.model.Skill
import com.eirinitelevantou.cv.ui.base.BaseFragment
import com.eirinitelevantou.cv.ui.experience.ExperienceAdapter
import com.eirinitelevantou.cv.utils.Navigator
import kotlinx.android.synthetic.main.fragment_experience.*

import javax.inject.Inject

class SkillsFragment : BaseFragment<FragmentSkillsBinding, SkillsFragmentViewModel>(), SkillsFragmentViewInterface {
    var adapter: SkillAdapter? = null

    override fun initAdapter(skills: List<Skill>?) {
        adapter = SkillAdapter(this!!.context!!, skills)
        recyclerView.adapter = adapter;
    }

    var navigator: Navigator? = null
        @Inject set

    var skillsFragmentViewModel: SkillsFragmentViewModel? = null
        @Inject set

    internal var fragmentSkillsStatsBinding: FragmentSkillsBinding? = null
    internal lateinit var relativeLayout: RelativeLayout

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
        relativeLayout = view.findViewById(R.id.parent)
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
