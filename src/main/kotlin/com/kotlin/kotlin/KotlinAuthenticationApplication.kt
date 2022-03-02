package com.kotlin.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinAuthenticationApplication

fun main(args: Array<String>) {
	runApplication<KotlinAuthenticationApplication>(*args)
}
