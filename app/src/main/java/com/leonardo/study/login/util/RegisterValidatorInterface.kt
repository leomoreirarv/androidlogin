package com.leonardo.study.login.util

interface RegisterValidatorInterface {

    fun isValidName(name:String):Boolean
    fun isValidUserName(userName:String):Boolean
    fun isValidPassword(password:String):Boolean
    fun isValidRepassword(password:String, repassword:String):Boolean
    fun isValidForm(formItems: Array<Boolean>):Boolean
}