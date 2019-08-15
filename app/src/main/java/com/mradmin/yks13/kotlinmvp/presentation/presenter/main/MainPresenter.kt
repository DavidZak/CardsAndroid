package com.mradmin.yks13.kotlinmvp.presentation.presenter.main

import com.mradmin.yks13.kotlinmvp.extension.handleApiError
import com.mradmin.yks13.kotlinmvp.model.CardsList
import com.mradmin.yks13.kotlinmvp.presentation.contract.MainContract
import com.mradmin.yks13.kotlinmvp.service.MainService
import com.mradmin.yks13.kotlinmvp.service.Service
import io.reactivex.disposables.CompositeDisposable

class MainPresenter: MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View
    private val service = Service.createService<MainService>()

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        loadCardsList("")
    }

    override fun loadCardsList(query: String) {

        val subscribe = service.getCardsList(query)
                .subscribe({ response: CardsList? ->
                    view.showProgress(false)
                    view.cardsListLoaded(response!!.data)
                }, { error ->
                    val err = error.handleApiError<CardsList>()
                    view.showProgress(false)
                    view.showErrorMessage(err)
                })

        subscriptions.add(subscribe)
    }
}