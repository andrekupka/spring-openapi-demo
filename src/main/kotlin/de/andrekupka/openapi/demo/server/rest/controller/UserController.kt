package de.andrekupka.openapi.demo.server.rest.controller

import de.andrekupka.openapi.demo.server.rest.apis.UsersApi
import de.andrekupka.openapi.demo.server.rest.models.CreateUserRequestTO
import de.andrekupka.openapi.demo.server.rest.models.UserListTO
import de.andrekupka.openapi.demo.server.rest.models.UserTO
import de.andrekupka.openapi.demo.server.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        private val userService: UserService
) : UsersApi {

    override fun createUser(createUserRequestTO: CreateUserRequestTO): ResponseEntity<UserTO> {
        val newUser = userService.createUser(createUserRequestTO.toCommand())
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser.toTransport())
    }

    override fun getUsers(): ResponseEntity<UserListTO> {
        val userList = UserListTO(userService.getUsers().map { it.toTransport() })
        return ResponseEntity.ok(userList)
    }
}