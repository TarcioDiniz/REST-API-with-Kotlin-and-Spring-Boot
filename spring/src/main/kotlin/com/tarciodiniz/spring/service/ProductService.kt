package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.dto.ProductDto
import com.tarciodiniz.spring.model.Product
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductService(
    private var products: List<Product> = ArrayList(),
    ) {

    fun getListProduct(): List<Product> {
        return products
    }

    fun getByUserId(userID: String): Product {
        return products.stream().filter { product ->
            product.userID == userID
        }.findFirst().get()
    }

    fun registerProduct(dto: ProductDto) {
        val nextId = products.size + 1L
        products = products.plus(
            Product(
                id = nextId,
                name = dto.name,
                description = dto.description,
                value = BigDecimal(dto.value),
                image = dto.image,
                userID = dto.userID
            )
        )
    }
}