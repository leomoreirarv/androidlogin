package com.leonardo.study.login.user.register

import com.leonardo.study.login.user.User
import com.leonardo.study.login.user.UserRepository

class RegisterInterator(private val repository: UserRepository) : RegisterInteractorInterface {
    override fun addUser(user: User) {
        repository.insert(user)
    }
}