package com.mradmin.yks13.kotlinmvp

import android.app.Application
import com.mradmin.yks13.kotlinmvp.di.component.ApplicationComponent
import com.mradmin.yks13.kotlinmvp.di.component.DaggerApplicationComponent
import com.mradmin.yks13.kotlinmvp.di.module.ApplicationModule

class MainApplication: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    private fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: MainApplication private set
    }
}