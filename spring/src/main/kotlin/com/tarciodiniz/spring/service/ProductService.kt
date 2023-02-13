package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.model.Product
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductService(private var products: List<Product>) {

    init {
        val product = Product(
            id = 2L,
            name = "produto teste",
            description = "cuida cuida", value = BigDecimal("22"),
            image = null,
            userID = "tarcio"
        )

        val product2 = Product(
            id = 2L,
            name = "produto teste",
            description = "cuida cuida", value = BigDecimal("22"),
            image = null,
            userID = "tarcio2"
        )

        val product3 = Product(
            id = 2L,
            name = "produto teste",
            description = "cuida cuida", value = BigDecimal("22"),
            image = null,
            userID = "tarcio3"
        )

        products = listOf(product, product2, product3)
    }

    fun getListProduct(): List<Product> {
        return products
    }


    fun getByUserId(userID: String): Product {
        return products.stream().filter { product ->
            product.userID == userID
        }.findFirst().get()
    }
}