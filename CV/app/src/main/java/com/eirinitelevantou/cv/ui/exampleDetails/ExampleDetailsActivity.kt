package com.eirinitelevantou.cv.ui.exampleDetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eirinitelevantou.cv.BR
import com.eirinitelevantou.cv.R
import com.eirinitelevantou.cv.databinding.ActivityExampleDetailsBinding
import com.eirinitelevantou.cv.network.model.Skill
import com.eirinitelevantou.cv.network.model.WorkExample
import com.eirinitelevantou.cv.ui.base.BaseActivity
import com.eirinitelevantou.cv.utils.Navigator
import com.pkfcooperparry.template.ui.exampleDetails.ExampleDetailsViewInterface
import com.pkfcooperparry.template.ui.exampleDetails.ExampleDetailsViewModel
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_example_details.*
import android.net.Uri


class ExampleDetailsActivity :
    BaseActivity<ActivityExampleDetailsBinding, ExampleDetailsViewModel>(),
    ExampleDetailsViewInterface {
    override fun openLink(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    override fun initAdapter(skills: List<Skill>?) {
       var adapter = SkillAdapter(this, skills)
        skillRecyclerView.adapter = adapter;
    }


    override fun handleError(message: String) {

    }

    override var viewModel: ExampleDetailsViewModel? = null
        @Inject set

    var navigator: Navigator? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)
        viewModel?.workExample = intent.getSerializableExtra("workExample") as WorkExample;
        setUp()
    }

    override val bindingVariable: Int
        get() = BR.viewModel

    override  var actionBarTitle: String = ""

    override val actionBarType: Int
        get() = BaseActivity.KEY_BACK_HOME_ACTION_BAR

    override val layoutId: Int
        get() = R.layout.activity_example_details

    override fun onFragmentAttached() {}

    fun setUp() {

        val imagePagerAdapter = ImagePagerAdapter(
            this,
            viewModel?.workExample?.screenshots
        )
        screenShotRecyclerView.adapter = imagePagerAdapter;
        screenShotRecyclerView.setOffscreenItems(3); //Reserve extra space equal to (childSize * count) on each side of the view
        screenShotRecyclerView.setOverScrollEnabled(true); //Can also be set using android:overScrollMode xml attribute
        screenShotRecyclerView.setSlideOnFling(false);
        screenShotRecyclerView.setItemTransformer(
            ScaleTransformer.Builder()
                .setMaxScale(1.00f)
                .setMinScale(0.7f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.CENTER) // CENTER is a default one
                .build()
        )

        screenShotRecyclerView.setNestedScrollingEnabled(false);

        skillRecyclerView.setNestedScrollingEnabled(false);
        actionBarTitle =  viewModel?.workExample?.title!!
        setupActionBar()
        setupActionBar()
    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, ExampleDetailsActivity::class.java)
        }
    }
}
