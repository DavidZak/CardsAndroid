package com.mradmin.yks13.kotlinmvp.service

import com.mradmin.yks13.kotlinmvp.api.ApiService

open class Service {
    protected val api = ApiService.create()

    companion object {
        inline fun <reified T: Service> createService(): T {
            return T::class.java.newInstance()
        }
    }
}
