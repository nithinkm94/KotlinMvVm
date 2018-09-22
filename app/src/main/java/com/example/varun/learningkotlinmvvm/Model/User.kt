package com.example.varun.learningkotlinmvvm.Model

import java.util.*


class User: Observable() {
var name:String=""
    set(value) {
        field=value
        setChangedAndNotify("name")
    }

    var email: String = ""
        set(value) {
            field = value
            setChangedAndNotify("email")
        }

    private fun setChangedAndNotify(field: Any)
    {
        setChanged()
        notifyObservers(field)
    }
}