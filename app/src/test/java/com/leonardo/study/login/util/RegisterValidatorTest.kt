package com.leonardo.study.login.util

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class RegisterValidatorTest{

    private lateinit var registerValidator: RegisterValidator

    @Before
    fun setup(){
        registerValidator = RegisterValidator()
    }

    @Test
    fun `When the name has less than 6 chars the validator return false` () {
        val isValid = registerValidator.isValidName("xpto")
        Assert.assertFalse(isValid)
    }

    @Test
    fun `When the name has more than 6 chars the validator return true` () {
        val isValid = registerValidator.isValidName("xptoxpto")
        Assert.assertTrue(isValid)
    }

    @Test
    fun `When the username has less than 6 chars the validator returns false` () {
        val isValid = registerValidator.isValidName("xpto")
        Assert.assertFalse(isValid)
    }

    @Test
    fun `When the username has more than 6 chars the validator returns true` () {
        val isValid = registerValidator.isValidUserName("xptoxpto")
        Assert.assertTrue(isValid)
    }

    @Test
    fun `When the password doesn't cover the requiriments the validator returns false` () {
        val isValid = registerValidator.isValidPassword("1234")
        Assert.assertFalse(isValid)
    }

    @Test
    fun `When the password cover the requiriments the validator return true` () {
        val isValid = registerValidator.isValidPassword("xpto!OtpX123")
        Assert.assertTrue(isValid)
    }

    @Test
    fun `When the password is different of the re-password the validator return false` () {
        val isValid = registerValidator.isValidRepassword("xpto", "otpx")
        Assert.assertFalse(isValid)
    }

    @Test
    fun `When the password is equals to the re-password the validator retuns true` () {
        val isValid = registerValidator.isValidRepassword("xpto", "xpto")
        Assert.assertTrue(isValid)
    }
}