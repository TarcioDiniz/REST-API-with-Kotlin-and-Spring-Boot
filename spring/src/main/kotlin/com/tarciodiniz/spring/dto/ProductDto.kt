package com.tarciodiniz.spring.dto

import java.math.BigDecimal

data class ProductDto (
    val name: String,
    val description: String,
    val value: String,
    val image: String? = null,
    val userID: String? = null
)