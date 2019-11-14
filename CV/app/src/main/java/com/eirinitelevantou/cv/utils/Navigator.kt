package com.eirinitelevantou.cv.utils

import android.app.Activity
import android.content.Context
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.network.model.Job
import com.eirinitelevantou.cv.network.model.WorkExample
import com.eirinitelevantou.cv.ui.exampleDetails.ExampleDetailsActivity
import com.eirinitelevantou.cv.ui.jobDetails.JobDetailsActivity
import com.eirinitelevantou.cv.ui.main.MainActivity

class Navigator {
    fun navigateToMainView(context: Context) {
        context.startActivity(MainActivity.getStartIntent(context))
        ActivityTransitions.setSlideExitToRightAnimation(context)
    }

    fun navigateToJobDetailsView(context: Context,job:Job) {
        val intent = JobDetailsActivity.getStartIntent(context);
        intent.putExtra("job",job)
        context.startActivity(intent)
        ActivityTransitions.setSlideExitToRightAnimation(context)
    }

    fun navigateToWorkExampleDetailsView(context: Context,workExample: WorkExample) {
        val intent = ExampleDetailsActivity.getStartIntent(context);
        intent.putExtra("workExample",workExample)
        context.startActivity(intent)
        ActivityTransitions.setSlideExitToRightAnimation(context)
    }

    private object ActivityTransitions {

        internal fun setFadeInOutAnimation(context: Context) {
            if(context is Activity)
                context.overridePendingTransition(
                        R.anim.anim_fade_in, R.anim.anim_fade_out)

        }

        internal fun setSlideExitToRightAnimation(context: Context) {
            if(context is Activity)
            context.overridePendingTransition(
                        R.anim.anim_no_change, R.anim.anim_slide_exit_to_right)
        }
    }
}//Required empty constructor
