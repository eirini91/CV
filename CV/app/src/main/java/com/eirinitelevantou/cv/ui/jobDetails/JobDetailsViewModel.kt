package com.pkfcooperparry.template.ui.jobDetails

import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import androidx.databinding.ObservableField


class JobDetailsViewModel internal constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider
) : BaseViewModel<JobDetailsViewInterface>(dataManager, schedulerProvider) {
    val title = ObservableField<String>()
    val company = ObservableField<String>()
    val address = ObservableField<String>()
    val dates = ObservableField<String>()
    val description = ObservableField<String>()
    val icon = ObservableField<String>()

    var job: Job? = null
        set(value) {
            title.set(value?.title)
            company.set(value?.company)
            address.set(value?.address)
            dates.set(value?.dates)
            description.set(value?.description)
            icon.set(value?.icon)
            field = value
        }
}