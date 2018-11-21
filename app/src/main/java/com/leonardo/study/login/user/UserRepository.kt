package com.leonardo.study.login.user

/**
 * val database = UserDatabase.getInstance(this)
 * val dao = database!!.userDao()
 */
class UserRepository(private val userDAO: UserDAO){
    fun insert(user: User){
        val id = userDAO.insert(user)
        user.id = id
    }

    fun getAll(): List<User>{
        return userDAO.getAll()
    }

    fun checkPassword(username: String, password: String): Boolean{
        var users: List<User> = userDAO.checkPassword(username, password)
        return !users.isEmpty()
    }

    fun selectUserById(id: Long): User {
        return userDAO.selectUserById(id)
    }

    fun deleteUser(user: User){
        userDAO.delete(user)
    }

    fun update(user: User) {
        userDAO.update(user)
    }
}