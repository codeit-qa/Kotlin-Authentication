package com.kotlin.kotlin.models

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class Auth {

    var email : String = ""

    var password : String = ""
}