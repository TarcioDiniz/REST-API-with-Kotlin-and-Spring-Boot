package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.model.User
import org.springframework.stereotype.Service

@Service
class UserService(private var users: List<User>) {

    fun getListUser(): List<User> {
        return users
    }

    fun registerUser(user: User) {
        if (users.any { it.id == user.id }) {
            throw IllegalArgumentException("User id must be unique.")
        } else {
            users = users.plus(
                User(
                    id = user.id,
                    name = user.name,
                    password = user.password
                )
            )
        }
    }
}