package de.andrekupka.openapi.demo.server.model

import java.time.LocalDate

data class CreateUserCommand(
        val name: String,
        val birthday: LocalDate,
)
