package com.leonardo.study.login.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
class User {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
    var username: String = ""
    var password: String = ""
    var name: String = ""
}