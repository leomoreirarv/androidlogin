package com.leonardo.study.login.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
class User(@PrimaryKey(autoGenerate = true) var id: Long?,
           @ColumnInfo(name = "username") var username: String,
           @ColumnInfo(name = "password") var password: String,
           @ColumnInfo(name = "name") var name: String){
    constructor():this(null, "","","")
}