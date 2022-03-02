package com.kotlin.kotlin.repositories

import com.kotlin.kotlin.models.Auth
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthRepository : MongoRepository<Auth, String>{


    fun findByEmail(email: String): Auth

}