package com.kotlin.kotlin.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User(name:String , email:String , password:String , phone:String) {
    @Id
    val id: ObjectId = ObjectId.get();

    var name:String = name;

    var email:String = email;

    var phone:String = phone;

    var password:String = password;
}