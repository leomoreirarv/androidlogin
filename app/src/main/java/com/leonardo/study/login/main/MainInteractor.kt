package com.leonardo.study.login.main

import com.leonardo.study.login.user.UserRepository

class MainInteractor(private val repository: UserRepository) {
    fun getUsers(){

    }

    fun getUser(id: Int){

    }

    fun saveUser(){

    }

    fun validadeUserPassword(username: String, password: String): Boolean{
        return repository.checkPassword(username, password)
    }
}