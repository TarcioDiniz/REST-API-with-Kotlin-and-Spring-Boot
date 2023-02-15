package com.tarciodiniz.spring.repository

import com.tarciodiniz.spring.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface RepositoryProduct: JpaRepository<Product, Long> {

    fun findByNameContaining(name: String): List<Product>

}
