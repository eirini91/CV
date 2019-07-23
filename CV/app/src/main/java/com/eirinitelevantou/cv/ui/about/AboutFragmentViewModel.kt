package com.pkfcooperparry.template.ui.form.page.tab


import android.content.Context
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentViewInterface
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider


class AboutFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<AboutFragmentViewInterface>(dataManager, schedulerProvider) {

    override fun setViewInterface(context: Context, navigator: AboutFragmentViewInterface) {
        super.setViewInterface(context, navigator)
    }


}
