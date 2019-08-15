package com.mradmin.yks13.kotlinmvp.di.component

import com.mradmin.yks13.kotlinmvp.di.module.ActivityModule
import com.mradmin.yks13.kotlinmvp.presentation.view.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}