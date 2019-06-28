package com.eirinitelevantou.cv.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.eirinitelevantou.cv.di.ActivityContext
import com.eirinitelevantou.cv.di.PerActivity
import com.eirinitelevantou.cv.ui.main.MainMvpPresenter
import com.eirinitelevantou.cv.ui.main.MainMvpView
import com.eirinitelevantou.cv.ui.main.MainPresenter
import com.eirinitelevantou.cv.ui.splash.SplashMvpPresenter
import com.eirinitelevantou.cv.ui.splash.SplashMvpView
import com.eirinitelevantou.cv.ui.splash.SplashPresenter
import com.eirinitelevantou.cv.utils.rx.AppSchedulerProvider
import com.eirinitelevantou.cv.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @PerActivity
    internal fun provideSplashPresenter(
        presenter: SplashPresenter<SplashMvpView>
    ): SplashMvpPresenter<SplashMvpView> {
        return presenter
    }


    @Provides
    @PerActivity
    internal fun provideMainPresenter(
        presenter: MainPresenter<MainMvpView>
    ): MainMvpPresenter<MainMvpView> {
        return presenter
    }

//    @Provides
//    internal fun provideFeedPagerAdapter(activity: AppCompatActivity): FeedPagerAdapter {
//        return FeedPagerAdapter(activity.supportFragmentManager)
//    }
//
//    @Provides
//    internal fun provideOpenSourceAdapter(): OpenSourceAdapter {
//        return OpenSourceAdapter(ArrayList<OpenSourceResponse.Repo>())
//    }
//
//    @Provides
//    internal fun provideBlogAdapter(): BlogAdapter {
//        return BlogAdapter(ArrayList<BlogResponse.Blog>())
//    }

    @Provides
    internal fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
}
