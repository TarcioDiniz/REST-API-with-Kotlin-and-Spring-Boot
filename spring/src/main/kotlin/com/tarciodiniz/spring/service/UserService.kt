package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.model.User
import org.springframework.stereotype.Service

@Service
class UserService {
    fun getListUser(): List<User> {
        val user = User("tarcio", "tarcio diniz", "1234")
        return listOf(user, user)
    }
}