package com.mradmin.yks13.kotlinmvp.di.component

import com.mradmin.yks13.kotlinmvp.MainApplication
import com.mradmin.yks13.kotlinmvp.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MainApplication)

}