package com.mradmin.yks13.kotlinmvp.api

import com.mradmin.yks13.kotlinmvp.model.Card
import com.mradmin.yks13.kotlinmvp.model.CardsList
import com.mradmin.yks13.kotlinmvp.util.Constants
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("cards/search")
    fun getCardsList(@Query("q") query: String): Observable<CardsList>

    companion object Factory {
        fun create(): ApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val okhttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

            val retrofit = retrofit2.Retrofit.Builder()
                    .client(okhttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
