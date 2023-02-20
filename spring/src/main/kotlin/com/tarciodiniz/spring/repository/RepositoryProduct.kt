package com.tarciodiniz.spring.repository

import com.tarciodiniz.spring.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RepositoryProduct: JpaRepository<Product, UUID> {

    fun findByNameContaining(name: String): List<Product>

}
