package com.pkfcooperparry.template.ui.form.page.tab


import android.content.Context
import androidx.databinding.ObservableBoolean
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.ui.experience.ExperienceFragmentViewInterface
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ExperienceFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<ExperienceFragmentViewInterface>(dataManager, schedulerProvider) {
    val isDataAvailable = ObservableBoolean(false)

    override fun setViewInterface(context: Context, navigator: ExperienceFragmentViewInterface) {
        super.setViewInterface(context, navigator)
        loadExperiences()
    }


    fun loadExperiences() {
        setIsLoading(true)
        compositeDisposable.add(
            dataManager
                .getJobs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())

                .subscribe({ response ->
                    setIsLoading(false)
                    if (response == null) {
                        isDataAvailable.set(false)
                    } else {
                        isDataAvailable.set(true)
                        getViewInterface().initAdapter(response.jobs)

                    }

                }, { throwable ->

                    setIsLoading(false)
                    isDataAvailable.set(false)
                })
        )
    }

}
