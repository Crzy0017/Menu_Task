package com.example.proba.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proba.R
import com.example.proba.model.Currency
import com.google.android.material.textfield.TextInputLayout

class CurrencyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_currency, parent, false)) {
    private val TextView = itemView.findViewById<TextView>(R.id.currencyTextView)
    private val hintText = itemView.findViewById<TextInputLayout>(R.id.outlinedTextField)
    private val flagView = itemView.findViewById<ImageView>(R.id.flagImageView)

    fun bind(item: Currency, clickListener: (name: Currency) -> Unit) {
        TextView.text = item.name
        hintText.hint = item.value.toString()
        flagView.setBackgroundResource(item.imageRes)

        TextView.setOnClickListener {
            clickListener(item)
        }
    }
}