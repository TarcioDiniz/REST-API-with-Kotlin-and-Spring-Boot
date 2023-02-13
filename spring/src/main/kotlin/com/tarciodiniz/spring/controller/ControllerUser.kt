package com.tarciodiniz.spring.controller

import com.tarciodiniz.spring.model.User
import com.tarciodiniz.spring.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Users")
class ControllerUser(private val service: UserService){
    @GetMapping
    fun getProducts(): List<User> {
        return service.getListUser()
    }

}