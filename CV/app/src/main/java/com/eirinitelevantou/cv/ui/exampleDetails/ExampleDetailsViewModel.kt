package com.pkfcooperparry. template.ui.exampleDetails

import androidx.databinding.ObservableBoolean
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import androidx.databinding.ObservableField
import com.eirinitelevantou.cv.network.model.Skill
import com.eirinitelevantou.cv.network.model.WorkExample
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ExampleDetailsViewModel internal constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider
) : BaseViewModel<ExampleDetailsViewInterface>(dataManager, schedulerProvider) {
    val title = ObservableField<String>()
    val description = ObservableField<String>()
    val url = ObservableField<String>()
    val hasImages = ObservableBoolean(false);

    val isLink = ObservableBoolean(false);
    var workExample: WorkExample? = null
        set(value) {
            title.set(value?.title)
            description.set(value?.description)
            if (value?.link != null) {
                isLink.set(true)
                url.set(value?.link)
            } else {
                isLink.set(false)
            }
            hasImages.set(value?.screenshots!=null && value?.screenshots?.size > 0)
            field = value
            loadSkills();
        }


    private fun loadSkills() {
        setIsLoading(true)
        compositeDisposable.add(
            dataManager
                .getSkills()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())

                .subscribe({ response ->
                    setIsLoading(false)

                    val allSkills: ArrayList<Skill>? = ArrayList<Skill>();
                    for (skill in response.skills!!) {
                        if (workExample?.technologies?.contains(skill.skillId)!!)
                            allSkills?.add(skill)
                        for (innerSkill in skill.items) {
                            if (workExample?.technologies?.contains(innerSkill.skillId)!!)
                                allSkills?.add(innerSkill)
                        }
                    }
                    getViewInterface().initAdapter(allSkills)
                }, { throwable ->
                    setIsLoading(false)
                })
        )
    }

    fun onGooglePlayClicked() {
        getViewInterface().openLink(workExample?.link!!)
    }
}