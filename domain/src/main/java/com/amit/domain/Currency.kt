package com.amit.domain

data class Currency(
    val id: Int,
    val rates: Rate?,
    val base: String,
    val date: String
)