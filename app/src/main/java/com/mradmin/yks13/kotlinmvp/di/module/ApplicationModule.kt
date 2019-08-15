package com.mradmin.yks13.kotlinmvp.di.module

import android.app.Application
import com.mradmin.yks13.kotlinmvp.MainApplication
import com.mradmin.yks13.kotlinmvp.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: MainApplication) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}