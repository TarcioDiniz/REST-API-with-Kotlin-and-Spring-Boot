package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.dto.ProductDto
import com.tarciodiniz.spring.dto.UpdateProductDto
import com.tarciodiniz.spring.exception.NotFoundException
import com.tarciodiniz.spring.model.Product
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductService(
    private var products: List<Product> = ArrayList(),
    private val notFoundMessage: String = "Product not found"
) {

    fun getListProduct(): List<Product> {
        return products
    }

    fun getByUserId(userID: String): Product {
        return products.stream().filter { product ->
            product.userID == userID
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }
    }

    fun registerProduct(dto: ProductDto): Long {
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
        return nextId
    }

    fun toUpdate(product: UpdateProductDto) {
        val productUp = products.stream().filter { p ->
            p.id == product.id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }
        products = products.minus(productUp).plus(
            Product(
                id = product.id,
                name = product.name,
                description = product.description,
                value = BigDecimal(product.value),
                image = product.image,
                userID = productUp.userID
            )
        )
    }

    fun delete(product: Product) {
        val productUp = products.stream().filter { p ->
            p.id == product.id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }
        products = products.minus(productUp)
    }
}