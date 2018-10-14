package com.leonardo.study.login.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface UserDAO {
    @Query("Select * from users")
    fun getAll(): List<User>

    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    //Encontrar uma forma de deletar apenas um registro, talvez usando where?
    @Query("Delete from users")
    fun deleteAll()
}