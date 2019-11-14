package com.eirinitelevantou.cv.ui.jobDetails

import com.eirinitelevantou.cv.network.model.Job

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.ActivityJobDetailsBinding
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.utils.Navigator
import com.pkfcooperparry.template.ui.jobDetails.JobDetailsViewInterface
import com.pkfcooperparry.template.ui.jobDetails.JobDetailsViewModel
import javax.inject.Inject
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_job_details.*
import kotlinx.android.synthetic.main.activity_job_details.image
import kotlinx.android.synthetic.main.activity_main.toolbar
import java.lang.Exception


class JobDetailsActivity : BaseActivity<ActivityJobDetailsBinding, JobDetailsViewModel>(),
    JobDetailsViewInterface {

    override fun handleError(message: String) {
    }

    override var viewModel: JobDetailsViewModel? = null
        @Inject set

    var navigator: Navigator? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)

        viewModel?.job = intent.getSerializableExtra("job") as Job;

        setUp()
    }

    override val bindingVariable: Int
        get() = BR.viewModel

    override var actionBarTitle: String = ""

    override val actionBarType: Int
        get() = BaseActivity.KEY_BACK_HOME_ACTION_BAR

    override val layoutId: Int
        get() = R.layout.activity_job_details

    override fun onFragmentAttached() {}

    fun setUp() {

        Picasso.get()
            .load(viewModel?.job?.icon)
            .into(image, object : com.squareup.picasso.Callback {
                override fun onError(e: Exception?) {
                }
                override fun onSuccess() {
                    if (progressBar1 != null) {
                        progressBar1.setVisibility(View.GONE)
                    }
                }
            })
        examplesRecyclerView.isNestedScrollingEnabled = false;
        responsibilitiesRecyclerView.isNestedScrollingEnabled = false;
        if (viewModel?.job?.responsibilities != null) {
            val responsibilitiesAdapter =
                ResponsibilitiesAdapter(this, viewModel?.job?.responsibilities) { item ->
                }
            responsibilitiesRecyclerView.adapter = responsibilitiesAdapter;
        }
        val adapter = WorkExperienceAdapter(this, viewModel?.job?.examples) { item ->
            navigator?.navigateToWorkExampleDetailsView(this, item)
        }
        examplesRecyclerView.adapter = adapter;
      actionBarTitle =  viewModel?.job?.title!!
        setSupportActionBar(toolbar)
        setupActionBar()
    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, JobDetailsActivity::class.java)
        }
    }
}
