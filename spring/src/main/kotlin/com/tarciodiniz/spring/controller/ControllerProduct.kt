package com.tarciodiniz.spring.controller

import com.tarciodiniz.spring.dto.ProductDto
import com.tarciodiniz.spring.dto.UpdateProductDto
import com.tarciodiniz.spring.model.Product
import com.tarciodiniz.spring.service.ProductService
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/Product")
class ControllerProduct(private val service: ProductService) {

    @GetMapping
    @Cacheable("product")
    fun getProducts(pageable: Pageable): Page<Product> {
        return service.getListProduct(pageable)
    }

    @GetMapping("/{userID}")
    fun getByUserId(@PathVariable userID: String): Product {
        return service.getByUserId(userID)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["product"], allEntries = true)
    fun registerProduct(@RequestBody @Valid product: ProductDto,
                        uriBuilder: UriComponentsBuilder): ResponseEntity<ProductDto>{
        val register = service.registerProduct(product)
        val uri = uriBuilder.path("/Product/${register}").build().toUri()
        return ResponseEntity.created(uri).body(product)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["product"], allEntries = true)
    fun toUpdate(@RequestBody @Valid product: UpdateProductDto){
        service.toUpdate(product)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = ["product"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}