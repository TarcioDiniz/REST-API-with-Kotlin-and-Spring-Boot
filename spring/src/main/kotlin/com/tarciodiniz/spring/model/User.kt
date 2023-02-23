package com.tarciodiniz.spring.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0L,
    @field:NotEmpty
    val username: String,
    val name: String,
    @field:NotEmpty
    val password: String
)

