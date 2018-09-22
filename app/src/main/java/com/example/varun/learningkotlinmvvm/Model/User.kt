package com.example.varun.learningkotlinmvvm.Model

import java.util.*


class User {


    var id = ""
    var name = ""
    var email = ""

    constructor(id: String, name: String, email: String) {
        this.id = id
        this.name = name
        this.email = email
    }
}