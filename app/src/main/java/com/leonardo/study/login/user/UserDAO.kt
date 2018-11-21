package com.leonardo.study.login.user

import android.arch.persistence.room.*

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE username == :username AND password == :password LIMIT 1")
    fun checkPassword(username: String, password: String) : List<User>

    @Insert
    fun insert(user: User): Long

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE id == :id")
    fun selectUserById(id: Long): User

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(user: User)
}