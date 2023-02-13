package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.model.User
import org.springframework.stereotype.Service

@Service
class UserService(private var users: List<User>) {

    fun getListUser(): List<User> {
        return users
    }

    fun registerUser(user: User) {
        users = users.plus(
            User(
                id = user.id,
                name = user.name,
                password = user.password
            )
        )
    }
}