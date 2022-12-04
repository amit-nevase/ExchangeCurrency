package com.amit.exchangecurrency.ui.main

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amit.exchangecurrency.R
import com.amit.exchangecurrency.ui.extensions.basicDiffUtil
import com.amit.exchangecurrency.ui.extensions.inflate
import com.amit.exchangecurrency.ui.extensions.round
import com.amit.domain.Currency

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private lateinit var mholder: ViewHolder
    private lateinit var currency: Currency

    var currencies: MutableList<Currency> by basicDiffUtil(
        mutableListOf(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.currency_item, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mholder = holder
        currency = currencies[position]
        holder.bind(currency)
    }

    fun setAmount(currency: Currency, amount: Int) {
        mholder.setAmounts(currency, amount)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var currencyEurTitle: TextView
        private var currencyJpyTitle: TextView
        private var currencyGbpTitle: TextView
        private var currencyBrlTitle: TextView

        init {
            super.itemView
            currencyEurTitle = itemView.findViewById(R.id.titleEurTextView)
            currencyJpyTitle = itemView.findViewById(R.id.titleJpyTextView)
            currencyGbpTitle = itemView.findViewById(R.id.titleGbpTextView)
            currencyBrlTitle = itemView.findViewById(R.id.titleBrlTextView)
        }

        @SuppressLint("SetTextI18n")
        fun bind(currency: Currency) {
            currencyEurTitle.text = currency.rates?.eUR?.round(2).toString()
            currencyJpyTitle.text = currency.rates?.jPY?.round(2).toString()
            currencyGbpTitle.text = currency.rates?.gBP?.round(2).toString()
            currencyBrlTitle.text = currency.rates?.bRL?.round(2).toString()
        }

        @SuppressLint("SetTextI18n")
        fun setAmounts(currency: Currency, amount: Int) {
            if (amount == 0) {
                bind(currency)
                return
            }
            currencyEurTitle.text = "${(amount.toDouble() * currency.rates?.eUR!!).round(2)}"
            currencyJpyTitle.text = "${(amount.toDouble() * currency.rates?.jPY!!).round(2)}"
            currencyGbpTitle.text = "${(amount.toDouble() * currency.rates?.gBP!!).round(2)}"
            currencyBrlTitle.text = "${(amount.toDouble() * currency.rates?.bRL!!).round(2)}"
        }
    }
}
