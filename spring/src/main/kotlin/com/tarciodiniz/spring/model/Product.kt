package com.tarciodiniz.spring.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
data class Product(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val valueProduct: BigDecimal,
    val image: String? = null,
    val userID: String? = null
)
