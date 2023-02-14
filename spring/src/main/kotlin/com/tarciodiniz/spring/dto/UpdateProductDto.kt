package com.tarciodiniz.spring.dto

import jakarta.validation.constraints.NotEmpty
import org.jetbrains.annotations.NotNull

data class UpdateProductDto(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    val name: String,
    val description: String,
    @field:NotEmpty
    val value: String,
    val image: String? = null,
)
