package de.andrekupka.openapi.demo.server.model

import java.time.LocalDate

data class User(
        val id: String,
        val name: String,
        val birthday: LocalDate
)