package com.mradmin.yks13.kotlinmvp.presentation.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.visibility
import com.mradmin.yks13.kotlinmvp.R
import com.mradmin.yks13.kotlinmvp.model.Card
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_card_layout.view.*

class MainAdapter(private val context: Context, private var cards: MutableList<Card>): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    constructor(context: Context):this(context, mutableListOf<Card>())

    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) {
        val card = cards[p1]
        p0.bind(card)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_card_layout, p0, false)
        return MainAdapter.MainViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun setItems(list: List<Card>) {
        this.cards.clear()
        this.cards.addAll(list)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        cards.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clearItems() {
        this.cards.clear()
        notifyDataSetChanged()
    }

    class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(card: Card) {
            val context = itemView.context

            itemView.tvName.text = card.name
            itemView.tvType.text = card.type
            itemView.tvOracle.text = card.oracleText
            itemView.tvArtist.text = context.resources.getString(R.string.artist, card.artist)
            //Picasso.get().load(card.imageUris?.small).into(itemView.ivImage)
            itemView.pb.visibility(View.GONE).accept(true)
            Picasso.get().load(card.imageUris?.small).into(itemView.ivImage, object : Callback {
                override fun onSuccess() {
                    itemView.pb.visibility(View.GONE).accept(false)
                }

                override fun onError(e: Exception?) {

                }
            })
        }
    }
}