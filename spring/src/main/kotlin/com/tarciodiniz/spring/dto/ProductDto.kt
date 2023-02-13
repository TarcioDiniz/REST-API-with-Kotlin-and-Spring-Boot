package com.tarciodiniz.spring.dto

import jakarta.validation.constraints.NotEmpty

data class ProductDto (
    @field:NotEmpty
    val name: String,
    val description: String,
    val value: String,
    val image: String? = null,
    val userID: String? = null
)