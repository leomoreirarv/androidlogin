package com.leonardo.study.login.user.register

import com.leonardo.study.login.user.User

interface RegisterViewInterface {
    fun showInvalidName()
    fun showInvalidUsername()
    fun showInvalidPassword()
    fun showInvalidRepassword()
    fun showValidInsertion()
    fun showInvalidInsertion()
    fun showInvalidForm()
}
