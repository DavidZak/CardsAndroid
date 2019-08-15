package com.mradmin.yks13.kotlinmvp.extension

import com.google.gson.GsonBuilder
import com.mradmin.yks13.kotlinmvp.model.ApiResponse
import retrofit2.HttpException

inline fun <reified T: ApiResponse> Throwable.handleApiError(): String {
    if (this is HttpException && this.response().errorBody() != null) {
        val body = this.response().errorBody()!!.string()
        val result = GsonBuilder().create().fromJson<T>(body, T::class.java)
        return result.details
    }
    return this.localizedMessage
}

