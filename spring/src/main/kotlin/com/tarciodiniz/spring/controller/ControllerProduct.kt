package com.tarciodiniz.spring.controller

import com.tarciodiniz.spring.dto.ProductDto
import com.tarciodiniz.spring.dto.UpdateProductDto
import com.tarciodiniz.spring.model.Product
import com.tarciodiniz.spring.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun registerProduct(@RequestBody @Valid product: ProductDto,
                        uriBuilder: UriComponentsBuilder): ResponseEntity<ProductDto>{
        val register = service.registerProduct(product)
        val uri = uriBuilder.path("/Product/${register}").build().toUri()
        return ResponseEntity.created(uri).body(product)
    }

    @PutMapping
    fun toUpdate(@RequestBody @Valid product: UpdateProductDto){
        service.toUpdate(product)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable product: Product){
        service.delete(product)
    }
}