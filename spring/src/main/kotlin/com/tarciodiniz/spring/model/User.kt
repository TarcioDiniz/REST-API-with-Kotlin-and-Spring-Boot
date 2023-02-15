package com.tarciodiniz.spring.model

import jakarta.persistence.Entity
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Entity
data class User(
    @field:NotEmpty
    val id: String,
    val name: String,
    @field:NotEmpty @field:Size(min = 3, max = 10)
    val password: String
)
