package com.leonardo.study.login.user

/**
 * val database = UserDatabase.getInstance(this)
 * val dao = database!!.userDao()
 */
class UserRepository(private val userDAO: UserDAO){
    fun insert(user: User){
        userDAO.insertAll(user)
    }

    fun getAll(): List<User>{
        return userDAO.getAll()
    }

    fun checkPassword(username: String, password: String): Boolean{
        var users: List<User> = userDAO.checkPassword(username, password)
        return !users.isEmpty()
    }
}