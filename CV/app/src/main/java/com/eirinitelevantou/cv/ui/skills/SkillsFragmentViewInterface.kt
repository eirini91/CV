package com.eirinitelevantou.cv.ui.skills

import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.network.model.Skill


interface SkillsFragmentViewInterface
{
    fun initAdapter(skills: List<Skill>?)

}