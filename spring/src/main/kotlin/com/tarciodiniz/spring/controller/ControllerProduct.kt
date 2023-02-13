package com.tarciodiniz.spring.controller

import com.tarciodiniz.spring.model.Product
import com.tarciodiniz.spring.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/Product")
class ControllerProduct (private val service: ProductService){

    @GetMapping
    fun getProducts(): List<Product> {
        return service.getListProduct()
    }

    @GetMapping("/{userID}")
    fun getByUserId(@PathVariable userID: String): Product{
        return service.getByUserId(userID)
    }


}