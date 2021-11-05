package de.andrekupka.openapi.demo.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpenapiServerApplication

fun main(args: Array<String>) {
    runApplication<OpenapiServerApplication>(*args)
}
