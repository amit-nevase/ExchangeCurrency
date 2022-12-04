package com.amit.exchangecurrency.data.server

import com.amit.exchangecurrency.data.toDomainCurrency
import com.amit.data.source.RemoteDataSource
import com.amit.domain.Currency

class CurrencyDataSource : RemoteDataSource {

    override suspend fun getLatestCurrencies(base: String): Currency {
        return CurrencyDb.service
            .getAllCurrencies(base, "2GGRpmJvqyLN4nzW2ocuSATt4LYO9mq2").await()
            .toDomainCurrency()
    }
}
