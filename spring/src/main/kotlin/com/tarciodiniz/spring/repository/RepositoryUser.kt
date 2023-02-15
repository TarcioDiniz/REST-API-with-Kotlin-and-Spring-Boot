package com.tarciodiniz.spring.repository

import com.tarciodiniz.spring.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface RepositoryUser: JpaRepository<User, Long> {
}