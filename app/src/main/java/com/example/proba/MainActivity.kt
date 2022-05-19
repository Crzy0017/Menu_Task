package com.example.proba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.proba.model.Currency
import com.example.proba.ui.CurrencyAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var currencyList = mutableListOf(
        Currency("Тенге, Казахстан", 1700000, R.drawable.kz),
        Currency("Евро, ЕС", 40000, R.drawable.eu),
        Currency("Доллары, США", 23000, R.drawable.usa),
        Currency("Лира, Турция", 67000, R.drawable.tur),
        Currency("Тенге, Казахстан", 8700000, R.drawable.kz),
        Currency("Евро, ЕС", 74000, R.drawable.eu),
        Currency("Лира, Турция", 47000, R.drawable.tur),
        Currency("Тенге, Казахстан", 700000, R.drawable.kz),
    )
    private var sortedList1 = currencyList.sortedBy { it.name }
    private var sortedList2 = currencyList.sortedBy { it.value }
    private var currencyAdapter: CurrencyAdapter? = null
    private var currencyManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupCurrency(currencyList)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_with_submenu, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort1 -> {
                setupCurrency(sortedList1 as MutableList<Currency>)
                true
            }
            R.id.sort2 -> {
                setupCurrency(sortedList2 as MutableList<Currency>)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupCurrency(list: MutableList<Currency>) {
        currencyAdapter = CurrencyAdapter(
            clickListener = {
                Log.d("currency", it.name)
            }
        )
        currencyManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = currencyAdapter
            layoutManager = currencyManager
        }

        currencyAdapter?.setItems(list)
        add()
    }

    private fun add() {
        val button: View = findViewById(R.id.Button)
        button.setOnClickListener {
            val newCurrency = Currency("Тенге, Казахстан", 500000, R.drawable.kz)
            currencyAdapter?.addItem(newCurrency)
            scroll()
        }
    }

    private fun scroll() {
        val smoothScroller = object : LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int =
                SNAP_TO_START
        }
        smoothScroller.targetPosition = currencyList.size+1
        currencyManager?.startSmoothScroll(smoothScroller)
    }
}