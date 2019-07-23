package com.eirinitelevantou.cv.ui.skills


import android.content.Context
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentViewInterface
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider


class SkillsFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SkillsFragmentViewInterface>(dataManager, schedulerProvider) {

    override fun setViewInterface(context: Context, navigator: SkillsFragmentViewInterface) {
        super.setViewInterface(context, navigator)
    }


}
