package com.leonardo.study.login.user

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class UserEntity : RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        private var INSTANCE: UserEntity? = null

        fun getInstance(context: Context): UserEntity? {
            if( INSTANCE == null){
                synchronized(UserEntity::class){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserEntity::class.java, "user.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}