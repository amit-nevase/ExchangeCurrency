package com.amit.exchangecurrency.data.server

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyDbService {

    @GET("latest")
    fun getAllCurrencies(
        @Query("base") base: String,
        @Query("apikey") apikey: String
    ): Deferred<Currency>
}
