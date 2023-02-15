package com.tarciodiniz.spring.controller

import com.tarciodiniz.spring.model.User
import com.tarciodiniz.spring.service.UserService
import jakarta.validation.Valid
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/Users")
class ControllerUser(private val service: UserService){
    @GetMapping
    fun getUsers(): List<User> {
        return service.getListUser()
    }

    @PostMapping
    @Transactional
    fun registerUser(@RequestBody @Valid user: User) {
        service.registerUser(user)
    }

}