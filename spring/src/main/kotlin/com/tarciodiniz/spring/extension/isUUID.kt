package com.tarciodiniz.spring.extension

import java.util.*

fun isUUID(str: String): Boolean {
    return try {
        UUID.fromString(str)
        true
    } catch (ex: IllegalArgumentException) {
        false
    }
}
