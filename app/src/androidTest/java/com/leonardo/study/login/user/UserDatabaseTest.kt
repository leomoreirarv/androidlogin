package com.leonardo.study.login.user

import android.arch.persistence.room.Insert
import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDatabaseTest {
    private lateinit var dao: UserDAO
    private lateinit var database: UserDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
        database = UserDatabase.getInstance(context)!!
        dao = database.userDao()
    }

    @After
    fun closeDb(){
        database.clearAllTables()
        database.close()
        UserDatabase.destroyInstance()
    }

    @Test
    fun testingAddInTheDB(){
        val user = insertUser()
        val selected = dao.getAll().first()
        Assert.assertTrue(assertEquals(user, selected))
    }

    @Test
    fun testingTheCorrectUserAndPassword (){
        insertUser()
        var list = dao.checkPassword("usertest", "userTest!09876")
        var isValid = list.isNotEmpty()
        Assert.assertTrue(isValid)
    }

    @Test
    fun testingWrongUserAndPassword (){
        insertUser()
        var list = dao.checkPassword("xpto", "xpto")
        var isValid = list.isNotEmpty()
        Assert.assertFalse(isValid)
    }

    @Test
    fun gettingAUserById (){
        val user = insertUser()
        val id = user.id
        val selected = dao.selectUserById(id)
        Assert.assertTrue(assertEquals(user, selected))
    }

    @Test
    fun deletingUserById(){
        val user = insertUser()
        dao.delete(user)
        Assert.assertTrue(dao.getAll().isEmpty())
    }

    @Test
    fun updatingUser(){
        val user = insertUser()
        user.name = "UPDATED"
        dao.update(user)
        val updated = dao.selectUserById(user.id)
        Assert.assertEquals("UPDATED", updated.name)
    }

    private fun assertEquals(user: User, selected:User): Boolean {
        return user.name == selected.name && user.username == selected.username && user.password == selected.password
    }

    private fun insertUser(): User{
        val user = User()
        user.name = "User test"
        user.username = "usertest"
        user.password = "userTest!09876"

        val id = dao.insert(user)
        user.id = id

        return user
    }

}