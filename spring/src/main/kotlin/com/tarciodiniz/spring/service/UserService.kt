package com.tarciodiniz.spring.service

import com.tarciodiniz.spring.model.User
import com.tarciodiniz.spring.repository.RepositoryUser
import org.springframework.stereotype.Service

@Service
class UserService(private var repository: RepositoryUser) {

    fun getListUser(): List<User> {
        return repository.findAll()
    }

    fun registerUser(user: User) {
        if (repository.findAll().any { it.username == user.username }) {
            throw IllegalArgumentException("User id must be unique.")
        } else {
            repository.save(
                User(
                    username = user.username,
                    name = user.name,
                    password = user.password
                )
            )
        }
    }
}