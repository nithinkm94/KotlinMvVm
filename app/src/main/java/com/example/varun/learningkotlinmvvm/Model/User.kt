package com.example.varun.learningkotlinmvvm.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "User")
data class User(@PrimaryKey(autoGenerate = true) var id: Int?,
                @ColumnInfo(name = "name") var name: String,
                @ColumnInfo(name = "email") var email: String

) {

    constructor() : this(null, "", "")

}