package com.pkfcooperparry.template.ui.exampleDetails

import com.eirinitelevantou.cv.network.model.Skill


interface ExampleDetailsViewInterface {

    fun handleError(message: String)

    fun initAdapter(skills: List<Skill>?)


    fun openLink(url:String)
}
