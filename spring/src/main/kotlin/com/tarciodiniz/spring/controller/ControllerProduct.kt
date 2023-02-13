package com.tarciodiniz.spring.controller

import com.tarciodiniz.spring.dto.ProductDto
import com.tarciodiniz.spring.model.Product
import com.tarciodiniz.spring.service.ProductService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/Product")
class ControllerProduct(private val service: ProductService) {

    @GetMapping
    fun getProducts(): List<Product> {
        return service.getListProduct()
    }

    @GetMapping("/{userID}")
    fun getByUserId(@PathVariable userID: String): Product {
        return service.getByUserId(userID)
    }

    @PostMapping
    fun registerProduct(@RequestBody dto: ProductDto) {
        service.registerProduct(dto)
    }
}