package com.mradmin.yks13.kotlinmvp.service

import com.mradmin.yks13.kotlinmvp.model.CardsList
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainService: Service() {

    fun getCardsList(query: String): Observable<CardsList> {
        return api.getCardsList(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}