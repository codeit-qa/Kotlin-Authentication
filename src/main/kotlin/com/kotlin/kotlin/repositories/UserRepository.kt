package com.kotlin.kotlin.repositories

import com.kotlin.kotlin.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User , String> {

}