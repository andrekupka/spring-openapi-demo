package de.andrekupka.openapi.demo.server.rest.controller

import de.andrekupka.openapi.demo.server.model.CreateUserCommand
import de.andrekupka.openapi.demo.server.model.User
import de.andrekupka.openapi.demo.server.rest.models.CreateUserRequestTO
import de.andrekupka.openapi.demo.server.rest.models.UserTO

fun CreateUserRequestTO.toCommand() = CreateUserCommand(
        name = name,
        birthday = birthday
)

fun User.toTransport() = UserTO(
        id = id,
        name = name,
        birthday = birthday,
)