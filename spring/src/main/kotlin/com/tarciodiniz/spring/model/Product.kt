package com.tarciodiniz.spring.model

import java.math.BigDecimal

data class Product(
    val id: Long = 0L,
    val name: String,
    val description: String,
    val value: BigDecimal,
    val image: String? = null,
    val userID: String? = null
)
