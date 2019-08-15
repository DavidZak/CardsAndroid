package com.mradmin.yks13.kotlinmvp.presentation.view.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.textChanges
import com.mradmin.yks13.base.BaseActivity
import com.mradmin.yks13.kotlinmvp.R
import com.mradmin.yks13.kotlinmvp.di.component.DaggerActivityComponent
import com.mradmin.yks13.kotlinmvp.di.module.ActivityModule
import com.mradmin.yks13.kotlinmvp.model.Card
import com.mradmin.yks13.kotlinmvp.presentation.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.layout_search_view.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var adapter: MainAdapter

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        injectDependency()

        presenter.attach(this)

    }

    override fun onPause() {
        super.onPause()
    }

    override fun initViews() {
        adapter = MainAdapter(this)
        rvCards.layoutManager = LinearLayoutManager(this)
        rvCards.adapter = adapter
        rvCards.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        toolbarSearch.clicks().subscribe {
            showSearchView(true)
        }

        ibClose.clicks().subscribe {
            if (etSearch.text.toString().isEmpty()) {
                showSearchView(false)
            } else {
                etSearch.text.clear()
            }
        }

        etSearch.textChanges()
                .debounce(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    showProgress(true)
                }.subscribe {
                    filterCardsList(it.toString())
                }

    }

    override fun filterCardsList(query: String) {
        presenter.loadCardsList(query)
    }

    override fun showSearchView(show: Boolean) {
        RxView.visibility(searchView, View.GONE).accept(show)
    }

    override fun showProgress(show: Boolean) {
        RxView.visibility(pb, View.GONE).accept(show)
    }

    override fun showErrorMessage(error: String) {
        adapter.clearItems()
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun cardsListLoaded(list: List<Card>) {
        adapter.setItems(list)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }

}
