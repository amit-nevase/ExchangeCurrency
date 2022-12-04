package com.amit.usecases

import com.amit.data.repository.CurrencyRepository
import com.amit.domain.Currency

class GetLatestCurrencies(private val currenciesRepository: CurrencyRepository) {
    suspend fun invoke(): List<Currency> = currenciesRepository.getLatestCurrencies()
}
