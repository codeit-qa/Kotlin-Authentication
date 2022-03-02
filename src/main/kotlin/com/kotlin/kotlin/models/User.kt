package com.kotlin.kotlin.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User {
    @Id
    val id: ObjectId = ObjectId.get();

    var name:String = "";

    var email:String = "";

    var phone:String = "";

    var password:String = "";
}