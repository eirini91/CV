package com.eirinitelevantou.cv.ui.skills


import android.content.Context
import androidx.databinding.ObservableBoolean
import com.eirinitelevantou.cv.network.DataManager
import com.eirinitelevantou.cv.network.model.Skill
import com.eirinitelevantou.cv.ui.base.BaseViewModel
import com.eirinitelevantou.cv.ui.skills.SkillsFragmentViewInterface
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SkillsFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SkillsFragmentViewInterface>(dataManager, schedulerProvider) {
    val isDataAvailable = ObservableBoolean(false)

    override fun setViewInterface(context: Context, navigator: SkillsFragmentViewInterface) {
        super.setViewInterface(context, navigator)
        loadSkills()
    }


    fun loadSkills() {
        setIsLoading(true)
        compositeDisposable.add(
            dataManager
                .getSkills()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())

                .subscribe({ response ->
                    setIsLoading(false)
                    if (response == null) {
                        isDataAvailable.set(false)
                    } else {
                        isDataAvailable.set(true)

                        val allSkills: ArrayList<Skill>? = ArrayList<Skill>();
                        for (skill in response.skills!!){
                            allSkills?.add(skill)
                            for(innerSkill in skill.items){
                                allSkills?.add(innerSkill)
                            }
                        }
                        getViewInterface().initAdapter(allSkills)
                    }

                }, { throwable ->
                    setIsLoading(false)
                    isDataAvailable.set(false)
                })
        )
    }
}
