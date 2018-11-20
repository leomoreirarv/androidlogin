package com.leonardo.study.login.user.register

import com.leonardo.study.login.util.RegisterValidatorInterface

class RegisterPresenter(private val view : RegisterViewInterface,
                        private val validatorInterface : RegisterValidatorInterface) {
    fun validateName(name: String) {
        val isValidName = validatorInterface.isValidName(name)
        if (!isValidName) {
            view.showInvalidName()
        }
    }

    fun validateUsername(username: String){
        val isValidUsername = validatorInterface.isValidUserName(username)
        if(!isValidUsername) {
            view.showInvalidUsername()
        }
    }

    fun validatePassword(password: String) {
        val isValidPassword = validatorInterface.isValidPassword(password)
        if(!isValidPassword) {
            view.showInvalidPassword()
        }
    }

    fun validateRepassword(password: String, repassword: String) {
        val isValidRepassword = validatorInterface.isValidRepassword(password, repassword)
        if(!isValidRepassword) {
            view.showInvalidRepassword()
        }
    }
}