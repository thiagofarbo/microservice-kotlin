package com.example.rest.card

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ApiCardApplication

fun main(args: Array<String>) {
	runApplication<ApiCardApplication>(*args)
}
