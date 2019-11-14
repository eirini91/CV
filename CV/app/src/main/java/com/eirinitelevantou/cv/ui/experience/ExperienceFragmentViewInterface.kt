package com.eirinitelevantou.cv.ui.experience

import com.eirinitelevantou.cv.network.model.Job


interface ExperienceFragmentViewInterface {
    fun initAdapter(jobs: List<Job>?)
}