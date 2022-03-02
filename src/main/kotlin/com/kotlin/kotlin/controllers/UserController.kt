package com.kotlin.kotlin.controllers

import com.kotlin.kotlin.models.User
import com.kotlin.kotlin.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class UserController(private val userRepository: UserRepository)  {

    @PostMapping("/signup")
    fun setUsers(@RequestBody user: User): ResponseEntity<Any> {
        val map: MutableMap<String, Any> = HashMap()
        try {
            userRepository.save(user);

            map["status"] = true;
            map["message"] = "User created successfully"

            return ResponseEntity<Any>(map, org.springframework.http.HttpStatus.OK)

        } catch (e: Exception) {
            map["status"] = false;
            map["message"] = "User creation failed";

            return ResponseEntity<Any>(map, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }


}