package com.kotlin.kotlin.controllers

import com.kotlin.kotlin.models.Auth
import com.kotlin.kotlin.models.User
import com.kotlin.kotlin.repositories.AuthRepository
import com.kotlin.kotlin.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class UserController(private val userRepository: UserRepository , private val authRepository: AuthRepository) {

    @PostMapping("/signup")
    fun setUsers(@RequestBody user: User): ResponseEntity<Any> {
        val map: MutableMap<String, Any> = HashMap()

        val userModel = User(
            user.name,
            user.email,
            BCrypt.hashpw(user.password, BCrypt.gensalt()),
//            user.password,
            user.phone,
        )

        return try {
            userRepository.save(userModel);

            map["status"] = true;
            map["message"] = "User created successfully"

            ResponseEntity<Any>(map, org.springframework.http.HttpStatus.OK)

        } catch (e: Exception) {
            map["status"] = false;
            map["message"] = "User creation failed";

            ResponseEntity<Any>(map, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @PostMapping("/signin")
    fun login(@RequestBody auth: Auth): ResponseEntity<Any> {
        val map: MutableMap<String, Any> = HashMap()

        return try {
            val user = authRepository.findByEmail(auth.email)
            if (user != null) {
                if (BCrypt.checkpw(auth.password, user.password)) {
                    map["status"] = true;
                    map["message"] = "User logged in successfully"
                    ResponseEntity<Any>(map, org.springframework.http.HttpStatus.OK)
                } else {
                    map["status"] = false;
                    map["message"] = "Invalid password"
                    ResponseEntity<Any>(map, org.springframework.http.HttpStatus.UNAUTHORIZED)
                }
            } else {
                map["status"] = false;
                map["message"] = "User not found"
                ResponseEntity<Any>(map, org.springframework.http.HttpStatus.NOT_FOUND)
            }

        } catch (e: Exception) {
            map["status"] = false;
            map["message"] = "Internal server error"

            ResponseEntity<Any>(map, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
        }



    }


}