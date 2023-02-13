package com.tarciodiniz.spring.controller

import com.tarciodiniz.spring.model.Product
import com.tarciodiniz.spring.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/Product")
class ControllerProduct {

    @GetMapping
    fun getProducts(): List<Product> {
        val product = Product(
            id = 2L,
            name = "produto teste",
            description = "cuida cuida", value = BigDecimal("22"),
            image = null,
            userID = User(
                "tarcio",
                "Tarcio Diniz",
                "1234",
            )
        )
        return listOf(product, product)
    }

}