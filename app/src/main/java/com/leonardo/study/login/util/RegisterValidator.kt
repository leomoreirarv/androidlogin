package com.leonardo.study.login.util

class RegisterValidator: RegisterValidatorInterface {
    override fun isValidName(name: String): Boolean {
        return name.length >= 6
    }

    override fun isValidUserName(userName: String): Boolean {
        return userName.length >= 6
    }

    override fun isValidPassword(password: String): Boolean {
        val PASSWORD_REGEX = """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#${'$'}%!\-_?&])(?=\S+${'$'}).{8,}""".toRegex()
        return PASSWORD_REGEX.matches(password)
    }

    override fun isValidRepassword(password: String, repassword: String): Boolean {
        return repassword.equals(password)
    }

}