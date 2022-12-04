package com.example.currencyconverter.ui.main

import android.app.Activity
import android.graphics.RectF
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.ui.extensions.inflate
import com.example.domain.Currency
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.fragment_currency.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class CurrencyFragment : Fragment(), OnChartValueSelectedListener {

    private val mOnValueSelectedRectF: RectF = RectF()

    private var amount: String = "0"
    private lateinit var adapter: CurrencyAdapter
    private var currenciesList: MutableList<Currency> = mutableListOf()

    private val viewModel: CurrencyViewModel by currentScope.viewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_currency)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        currencyList.layoutManager = mLayoutManager
        currencyList.setHasFixedSize(true)

        adapter = CurrencyAdapter()
        currencyList.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: CurrencyViewModel.UiModel) {
        containerProgressIndicator.visibility =
            if (model is CurrencyViewModel.UiModel.Loading) View.VISIBLE else View.GONE

        when (model) {
            is CurrencyViewModel.UiModel.Content -> {
                currenciesList = adapter.currencies
                adapter.currencies = model.currencies

                amount = amountEditText.text.toString()

//                adapter.currencies[0].rates?.getMap()
                Log.e("Keys size", "" + adapter.currencies[0].rates?.getMap()?.keys?.toList()?.size)

                val currencyList = adapter.currencies[0].rates?.getMap()?.keys?.toList()
                for (i in adapter.currencies[0].rates?.getMap()?.keys?.toList()!!) {
                    Log.e("CURRENCY", "" + i)
                }
                amountEditText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        amount = p0.toString()
                        if (amount.isEmpty()){
                            return
                        }
                        amountTargetText.text = adapter.currencies[0].rates?.getMap()?.getValue(
                            toCurrencyLabel.selectedItem.toString()
                        )?.times(amount.toInt())
                            .toString()
                    }
                })
                amountEditText.setOnEditorActionListener(object : TextView.OnEditorActionListener {
                    override fun onEditorAction(
                        text: TextView,
                        actionId: Int,
                        event: KeyEvent?
                    ): Boolean {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEND || event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                            amount = text.text.toString()

                            if (amount.isEmpty()) {
                                return true
                            }

//                            Log.e("Keys size", "" + adapter.currencies[0].rates?.propertyMap?.keys?.toList()?.size)
                            amountTargetText.text =
                                adapter.currencies[0].rates?.eUR?.times(amount.toInt()).toString()
                            setData(
                                MAX_CHART_HORIZONTAL,
                                MAX_RANGE,
                                if (adapter.currencies[0].rates?.eUR!! > 0.0) {
                                    adapter.currencies[0].rates?.eUR?.times(amount.toInt())
                                } else {
                                    adapter.currencies[0].rates?.eUR
                                },
                                if (adapter.currencies[0].rates?.jPY!! > 0.0) {
                                    adapter.currencies[0].rates?.jPY?.times(amount.toInt())
                                } else {
                                    adapter.currencies[0].rates?.jPY
                                },
                                if (adapter.currencies[0].rates?.gBP!! > 0.0) {
                                    adapter.currencies[0].rates?.gBP?.times(amount.toInt())
                                } else {
                                    adapter.currencies[0].rates?.gBP
                                },
                                if (adapter.currencies[0].rates?.bRL!! > 0.0) {
                                    adapter.currencies[0].rates?.bRL?.times(amount.toInt())
                                } else {
                                    adapter.currencies[0].rates?.bRL
                                }
                            )

                            adapter.setAmount(adapter.currencies[0], amount.toInt())
                            hideKeyboard(requireActivity())
                            return true
                        }
                        return true
                    }
                })
                // Spinner 2
                val adapter1 = currencyList?.toTypedArray()?.let {
                    ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        it
                    )
                }
                adapter1?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                toCurrencyLabel.adapter = adapter1
                toCurrencyLabel.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            position: Int,
                            p3: Long
                        ) {
                            if (amount.isEmpty()) {
                                return
                            }
                            Log.e("CURRENCY item", "" + "" + (currencyList?.get(position) ?: ""))
                            amountTargetText.text = adapter.currencies[0].rates?.getMap()?.getValue(
                                currencyList?.get(position) ?: ""
                            )?.times(amount.toInt())
                                .toString()
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }
                    }

                horizontalChart.setOnChartValueSelectedListener(this)
                // chart.setHighlightEnabled(false);

                horizontalChart.setDrawBarShadow(false)

                horizontalChart.setDrawValueAboveBar(true)

                horizontalChart.description.isEnabled = false

                // if more than 60 entries are displayed in the chart, no values will be
                // drawn
                horizontalChart.setMaxVisibleValueCount(60)

                // scaling can now only be done on x- and y-axis separately
                horizontalChart.setPinchZoom(false)

                // draw shadows for each bar that show the maximum value
                // chart.setDrawBarShadow(true);

                horizontalChart.setDrawGridBackground(false)

                val xl: XAxis = horizontalChart.xAxis
                xl.position = XAxis.XAxisPosition.BOTTOM
                xl.setDrawAxisLine(true)
                xl.setDrawGridLines(false)
                xl.granularity = 10f

                val yl: YAxis = horizontalChart.axisLeft
                yl.setDrawAxisLine(true)
                yl.setDrawGridLines(true)
                yl.axisMinimum = 0f

                val yr: YAxis = horizontalChart.axisRight
                yr.setDrawAxisLine(true)
                yr.setDrawGridLines(false)
                yr.axisMinimum = 0f

                horizontalChart.setFitBars(true)
                horizontalChart.animateY(2500)

                val l: Legend = horizontalChart.legend
                l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
                l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
                l.orientation = Legend.LegendOrientation.HORIZONTAL
                l.setDrawInside(false)
                l.formSize = 8f
                l.xEntrySpace = 4f
            }
            CurrencyViewModel.UiModel.showUI -> {
                viewModel.showUi()
            }
        }
    }

    private fun setData(
        count: Int,
        range: Float,
        eur: Double?,
        jpy: Double?,
        gbp: Double?,
        brl: Double?
    ) {
        val barWidth = 9f
        val spaceForBar = 10f
        val values: ArrayList<BarEntry> = ArrayList()

        for (pos in 0..count) {
            var value = eur?.times(range)?.toFloat()
            when (pos) {
                0 -> values.add(
                    BarEntry(pos * spaceForBar, value!!, null)
                )
                1 -> {
                    value = jpy?.times(range)?.toFloat()
                    values.add(
                        BarEntry(pos * spaceForBar, value!!, null)
                    )
                }
                2 -> {
                    value = gbp?.times(range)?.toFloat()
                    values.add(
                        BarEntry(pos * spaceForBar, value!!, null)
                    )
                }
                3 -> {
                    value = brl?.times(range)?.toFloat()
                    values.add(
                        BarEntry(pos * spaceForBar, value!!, null)
                    )
                }
            }
        }

        val set1: BarDataSet
        val set2: BarDataSet
        val set3: BarDataSet
        val set4: BarDataSet

        if (horizontalChart.data != null && horizontalChart.data.dataSetCount > 0) {
            set1 = horizontalChart.data.getDataSetByIndex(0) as BarDataSet
            set2 = horizontalChart.data.getDataSetByIndex(1) as BarDataSet
            set3 = horizontalChart.data.getDataSetByIndex(2) as BarDataSet
            set4 = horizontalChart.data.getDataSetByIndex(3) as BarDataSet
            set1.values = values
            set2.values = values
            set3.values = values
            set4.values = values
            horizontalChart.data.notifyDataChanged()
            horizontalChart.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(values, "EUR")
            set2 = BarDataSet(values, "JPY")
            set3 = BarDataSet(values, "GBP")
            set4 = BarDataSet(values, "BLR")

            set1.setDrawIcons(false)
            set1.setColors(resources.getColor(R.color.darkBlue))
            set2.setColors(resources.getColor(R.color.red))
            set3.setColors(resources.getColor(R.color.blue))
            set4.setColors(resources.getColor(R.color.green))

            val dataSets: ArrayList<IBarDataSet> = ArrayList()
            dataSets.add(set1)
            dataSets.add(set2)
            dataSets.add(set3)
            dataSets.add(set4)

            val data = BarData(dataSets)
            data.setValueTextSize(10f)
            data.barWidth = barWidth
            horizontalChart.data = data
        }
    }

    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        // Find the currently focused view, so we can grab the correct window token from it.
        var view: View? = activity.currentFocus
        // If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onNothingSelected() {
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        if (e == null) {
            return
        }

        val bounds: RectF = mOnValueSelectedRectF
        horizontalChart.getBarBounds((e as BarEntry), bounds)

        val position: MPPointF = horizontalChart.getPosition(
            e,
            h?.dataSetIndex?.let { horizontalChart.data.getDataSetByIndex(it).axisDependency }
        )

        Log.i("bounds", bounds.toString())
        Log.i("position", position.toString())

        MPPointF.recycleInstance(position)
    }

    companion object {
        private val MAX_CHART_HORIZONTAL = 3
        private val MAX_RANGE = 100F
    }
}
