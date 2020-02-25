package com.example.rest.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiCardApplication

fun main(args: Array<String>) {
	runApplication<ApiCardApplication>(*args)
}
