package com.leonardo.study.login.user.register

import android.widget.EditText
import com.leonardo.study.login.user.User
import com.leonardo.study.login.util.RegisterValidatorInterface

class RegisterPresenter(private val view : RegisterViewInterface,
                        private val validatorInterface : RegisterValidatorInterface) {

    private val formItemsValidation = Array(4) {false}

    fun validateName(name: String) {
        val isValidName = validatorInterface.isValidName(name)
        formItemsValidation[0] = isValidName
        if (!isValidName) {
            view.showInvalidName()
        }
    }

    fun validateUsername(username: String){
        val isValidUsername = validatorInterface.isValidUserName(username)
        formItemsValidation[1] = isValidUsername
        if(!isValidUsername) {
            view.showInvalidUsername()
        }
    }

    fun validatePassword(password: String) {
        val isValidPassword = validatorInterface.isValidPassword(password)
        formItemsValidation[2] = isValidPassword
        if(!isValidPassword) {
            view.showInvalidPassword()
        }
    }

    fun validateRepassword(password: String, repassword: String) {
        val isValidRepassword = validatorInterface.isValidRepassword(password, repassword)
        formItemsValidation[3] = isValidRepassword
        if(!isValidRepassword) {
            view.showInvalidRepassword()
        }
    }

    fun validateForm(){
        var isValidForm = validatorInterface.isValidForm(formItemsValidation)
        if(!isValidForm) {
            view.showInvalidForm()
        }
    }

    fun doRegister(name: String, username: String, password: String){
        val user = User()
        user.name = name
        user.username = username
        user.password = password
    }
}