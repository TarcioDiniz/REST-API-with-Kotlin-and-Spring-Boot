package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.dto.ProductDto
import com.tarciodiniz.spring.dto.UpdateProductDto
import com.tarciodiniz.spring.exception.NotFoundException
import com.tarciodiniz.spring.model.Product
import com.tarciodiniz.spring.repository.RepositoryProduct
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.math.BigDecimal

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

    fun registerProduct(dto: ProductDto){
        repository.save(
            Product(
                name = dto.name,
                description = dto.description,
                valueProduct = BigDecimal(dto.valueProduct),
                image = dto.image,
                userID = dto.userID
            )
        )
    }

    fun toUpdate(product: UpdateProductDto) {
        val productUser = repository.findById(product.id).orElseThrow {
            NotFoundException(notFoundMessage)
        }
        repository.delete(
            Product(
                id = product.id,
                name = product.name,
                description = product.description,
                valueProduct = BigDecimal(product.value),
                image = product.image,
                userID = productUser.userID
            )
        )
    }

    fun delete(id: Long) {
        val product = repository.findById(id).stream().filter { p ->
            p.id == id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }
        repository.delete(product)
    }
}