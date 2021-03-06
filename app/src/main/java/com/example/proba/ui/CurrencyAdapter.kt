package com.example.proba.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proba.model.Currency

class CurrencyAdapter(
    private val clickListener: (name: Currency) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<Currency>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CurrencyViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CurrencyViewHolder).bind(data[position], clickListener)
    }

    fun addItem(item: Currency) {
        data.add(item)
        notifyItemInserted(data.size)
    }

    fun setItems(list: List<Currency>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}