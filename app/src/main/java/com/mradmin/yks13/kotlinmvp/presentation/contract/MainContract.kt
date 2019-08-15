package com.mradmin.yks13.kotlinmvp.presentation.contract

import com.mradmin.yks13.base.BaseContract
import com.mradmin.yks13.kotlinmvp.model.Card

class MainContract {

    interface View: BaseContract.View {
        fun filterCardsList(query: String)
        fun showSearchView(show: Boolean)
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun cardsListLoaded(list: List<Card>)
        fun initViews()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadCardsList(query: String)
    }
}