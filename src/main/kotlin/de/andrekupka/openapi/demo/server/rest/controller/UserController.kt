package de.andrekupka.openapi.demo.server.rest.controller

import de.andrekupka.openapi.demo.server.rest.apis.UsersApi
import de.andrekupka.openapi.demo.server.rest.models.CreateUserRequestTO
import de.andrekupka.openapi.demo.server.rest.models.ErrorTO
import de.andrekupka.openapi.demo.server.rest.models.UserListTO
import de.andrekupka.openapi.demo.server.rest.models.UserTO
import de.andrekupka.openapi.demo.server.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        private val userService: UserService
) : UsersApi {

    @ExceptionHandler(NotFoundException::class)
    fun handle(e: NotFoundException) = e.toResponseEntity()

    override fun createUser(createUserRequestTO: CreateUserRequestTO): ResponseEntity<UserTO> {
        val newUser = userService.createUser(createUserRequestTO.toCommand())
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser.toTransport())
    }

    override fun getUsers(): ResponseEntity<UserListTO> {
        val userList = UserListTO(userService.getUsers().map { it.toTransport() })
        return ResponseEntity.ok(userList)
    }

    override fun getUser(id: String): ResponseEntity<UserTO> {
        val user = userService.getUser(id) ?: throw NotFoundException("User has not been found!")
        return ResponseEntity.ok(user.toTransport())
    }

    override fun deleteUser(id: String): ResponseEntity<Unit> {
        val wasDeleted = userService.deleteUser(id)
        return if (wasDeleted) {
            ResponseEntity.noContent().build()
        } else throw NotFoundException("User has not been found!")
    }
}