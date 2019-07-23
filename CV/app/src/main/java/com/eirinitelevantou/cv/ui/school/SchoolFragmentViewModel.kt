package com.eirinitelevantou.cv.ui.school


import android.content.Context
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider


class SchoolFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SchoolFragmentViewInterface>(dataManager, schedulerProvider) {

    override fun setViewInterface(context: Context, navigator: SchoolFragmentViewInterface) {
        super.setViewInterface(context, navigator)
    }


}
