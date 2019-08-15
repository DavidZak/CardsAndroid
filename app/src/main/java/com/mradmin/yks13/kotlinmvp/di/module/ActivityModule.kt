package com.mradmin.yks13.kotlinmvp.di.module

import android.app.Activity
import com.mradmin.yks13.kotlinmvp.presentation.contract.MainContract
import com.mradmin.yks13.kotlinmvp.presentation.presenter.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}