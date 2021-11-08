package de.andrekupka.openapi.demo.server.rest.controller

import de.andrekupka.openapi.demo.server.rest.models.ErrorTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

sealed class ApiException(
    private val status: HttpStatus,
    private val description: String,
    private val code: String
) : RuntimeException() {
    fun toResponseEntity() = ResponseEntity.status(status).body(ErrorTO(code, description))
}

class NotFoundException(description: String, code: String = "not_found") : ApiException(HttpStatus.NOT_FOUND, description, code)