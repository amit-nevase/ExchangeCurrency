package com.amit.data.source

import com.amit.domain.Currency

interface RemoteDataSource {
    suspend fun getLatestCurrencies(base: String): Currency
}