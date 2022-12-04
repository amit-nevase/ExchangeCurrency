package com.amit.exchangecurrency.di

import android.app.Application
import com.amit.exchangecurrency.data.database.CurrencyDatabase
import com.amit.exchangecurrency.data.database.RoomDataSource
import com.amit.exchangecurrency.data.server.CurrencyDataSource
import com.amit.exchangecurrency.ui.main.CurrencyFragment
import com.amit.exchangecurrency.ui.main.CurrencyViewModel
import com.amit.data.repository.CurrencyRepository
import com.amit.data.source.LocalDataSource
import com.amit.data.source.RemoteDataSource
import com.amit.usecases.GetLatestCurrencies
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single { CurrencyDatabase.build(get()) }
    factory<LocalDataSource> { RoomDataSource(get()) }
    factory<RemoteDataSource> { CurrencyDataSource() }
    single<CoroutineDispatcher> { Dispatchers.Main }
}

val dataModule = module {
    factory { CurrencyRepository(get(), get()) }
}

private val scopesModule = module {
    scope(named<CurrencyFragment>()) {
        viewModel { CurrencyViewModel(get(), get()) }
        scoped { GetLatestCurrencies(get()) }
    }
}