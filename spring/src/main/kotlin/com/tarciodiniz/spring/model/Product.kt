package com.tarciodiniz.spring.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
data class Product(
    @Id
    val id: String = UUID.randomUUID().toString(),
    var name: String,
    var description: String,
    var valueProduct: BigDecimal,
    var image: String? = null,
    val userID: String? = null
)
