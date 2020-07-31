package com.demoapp.vara

class UserData {
    var id: String? = null
    var email: String? = null

    constructor() {}

    constructor(id: String, email: String) {
        this.id = id
        this.email = email
    }

    constructor(email: String) {
        this.email = email
    }

    fun toMap(): Map<String, Any> {

        val result = HashMap<String, Any>()
        result.put("email", email!!)

        return result
    }
}