package com.example.currencyconverter.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import com.example.currencyconverter.navigation.Navigation
import com.example.currencyconverter.ui.main.CurrencyFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        initViews()
    }

    private fun initViews() {
        initCurrencyFragment()
    }

    private fun initCurrencyFragment() {
        Navigation.replaceFragment(
            supportFragmentManager,
            R.id.fragmentContainer,
            CurrencyFragment()
        )
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    companion object {
        private val CLASS_TAG = MainActivity::class.java.simpleName
    }
}
