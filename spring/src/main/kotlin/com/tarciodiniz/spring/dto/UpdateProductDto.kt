package com.tarciodiniz.spring.dto

import jakarta.validation.constraints.NotEmpty
import org.jetbrains.annotations.NotNull

data class UpdateProductDto(
    @field:NotNull
    val id: String,
    @field:NotEmpty
    val name: String,
    val description: String,
    @field:NotEmpty
    val valueProduct: String,
    val image: String? = null,
    val userID: String? = null
)
