package com.leonardo.study.login

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabasePDO(context: Context) : SQLiteOpenHelper(context, DatabasePDO.DB_NAME, null, DatabasePDO.DB_VERSION){
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $NAME TEXT, $DESC TEXT, $COMPLETED TEXT);"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    companion object {
        private val DB_VERSION = 1
        private val DB_NAME = "LoginStudy"
        private val TABLE_NAME = "Users"
        private val ID = "Id"
        private val NAME = "Name"
        private val DESC = "Desc"
        private val COMPLETED = "Completed"
    }
}