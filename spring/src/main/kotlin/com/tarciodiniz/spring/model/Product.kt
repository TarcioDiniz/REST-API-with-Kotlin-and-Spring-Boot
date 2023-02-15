package com.tarciodiniz.spring.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0L,
    val name: String,
    val description: String,
    val valueProduct: BigDecimal,
    val image: String? = null,
    val userID: String? = null
)
