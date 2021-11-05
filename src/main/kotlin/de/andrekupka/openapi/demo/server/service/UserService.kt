package de.andrekupka.openapi.demo.server.service

import de.andrekupka.openapi.demo.server.model.CreateUserCommand
import de.andrekupka.openapi.demo.server.model.User
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Service
class UserService {

    private val userMap: MutableMap<String, User> = ConcurrentHashMap()

    fun getUsers(): List<User> {
        return userMap.values.sortedBy { it.id }
    }

    fun getUser(id: String): User? = userMap[id]

    fun createUser(command: CreateUserCommand): User {
        val id = UUID.randomUUID().toString()
        val user = command.toUser(id)
        userMap[id] = user
        return user
    }

    private fun CreateUserCommand.toUser(id: String) = User(
            id = id,
            name = name,
            birthday = birthday
    )
}