package com.example.currencyconverter.data.server

import com.example.currencyconverter.data.toDomainCurrency
import com.example.data.source.RemoteDataSource
import com.example.domain.Currency

class CurrencyDataSource : RemoteDataSource {

    override suspend fun getLatestCurrencies(base: String): Currency {
        return CurrencyDb.service
            .getAllCurrencies(base, "2GGRpmJvqyLN4nzW2ocuSATt4LYO9mq2").await()
            .toDomainCurrency()
    }
}
