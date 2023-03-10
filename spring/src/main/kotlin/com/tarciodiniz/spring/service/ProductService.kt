package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.dto.ProductDto
import com.tarciodiniz.spring.dto.UpdateProductDto
import com.tarciodiniz.spring.exception.NotFoundException
import com.tarciodiniz.spring.extension.isUUID
import com.tarciodiniz.spring.model.Product
import com.tarciodiniz.spring.repository.RepositoryProduct
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class ProductService(
    private val repository: RepositoryProduct,
    private val notFoundMessage: String = "Product not found"
) {

//    * USING PAGINATION *
//       just use in url:
//
//            1 - to specify the size:
//                 http://__/Product?size=2
//
//            2 - to specify size and page
//                http://__/Product?size=2&page=2
//
//      * Pageable spring sorting by url *
//          just use in url:

//            1 - http://__/Product?size=2&sort=valueProduct,desc
//
//    Learn more about pagination and sorting features by referring to
//    the official Spring Boot documentation.
//    https://docs.spring.io/spring-data/rest/docs/current/reference/html/#paging-and-sorting

    fun getListProduct(pageable: Pageable): Page<Product> {
        return repository.findAll(pageable)
    }

    fun getByUserId(userID: String): Product {
        return repository.findByNameContaining(userID).stream().filter { product ->
            product.userID == userID
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }
    }

    fun registerProduct(dto: ProductDto) {
        repository.save(
            Product(
                id = UUID.randomUUID().toString(),
                name = dto.name,
                description = dto.description,
                valueProduct = BigDecimal(dto.valueProduct),
                image = dto.image,
                userID = dto.userID
            )
        )
    }

    fun toUpdate(product: UpdateProductDto, id: String) {
        if (!isUUID(id)) {
            return
        }

        val existingProduct = repository.findById(id).orElse(null)
            ?: Product(id = id,
                name = product.name,
                description = product.description,
                valueProduct = BigDecimal(product.valueProduct),
                image = product.image,
                userID = product.userID)

        existingProduct.apply {
            name = product.name
            description = product.description
            valueProduct = BigDecimal(product.valueProduct)
            image = product.image
        }

        repository.save(existingProduct)
    }


    fun delete(id: String) {
        val product = repository.findById(id).stream().filter { p ->
            p.id == id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }
        repository.delete(product)
    }
}
