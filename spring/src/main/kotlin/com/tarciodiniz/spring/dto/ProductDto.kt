package com.tarciodiniz.spring.dto

import jakarta.validation.constraints.NotEmpty

data class ProductDto (
    @field:NotEmpty(message = "empty name")
    val name: String,
    val description: String,
    val valueProduct: String,
    val image: String? = null,
    val userID: String? = null
)