package com.leonardo.study.login.user.register

import com.leonardo.study.login.util.RegisterValidatorInterface
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RegisterPresenterTest {

    @Mock private lateinit var view: RegisterViewInterface
    @Mock private lateinit var validatorInterface: RegisterValidatorInterface

    private lateinit var presenter: RegisterPresenter

    @Before
    fun setup() {
        presenter = RegisterPresenter(view, validatorInterface)
    }

    @Test
    fun `When the name is invalid`() {
        doReturn(false).`when`(validatorInterface).isValidName(any())
        presenter.validateName("joao")
        verify(view).showInvalidName()
    }

    @Test
    fun `When the name is valid`() {
        doReturn(true).`when`(validatorInterface).isValidName(any())
        presenter.validateName("joao")
        verify(view, never()).showInvalidName()
    }

    @Test
    fun `When the username is invalid` () {
        doReturn(false).`when`(validatorInterface).isValidUserName(any())
        presenter.validateUsername("xpto")
        verify(view).showInvalidUsername()
    }

    @Test
    fun `When the username is valid` () {
        doReturn(true).`when`(validatorInterface).isValidUserName(any())
        presenter.validateUsername("xpto")
        verify(view, never()).showInvalidUsername()
    }

    @Test
    fun `When the password is invalid` () {
        doReturn(false).`when`(validatorInterface).isValidPassword(any())
        presenter.validatePassword("xpto")
        verify(view).showInvalidPassword()
    }

    @Test
    fun `When the password is valid` () {
        doReturn(true).`when`(validatorInterface).isValidPassword(any())
        presenter.validatePassword("xpto")
        verify(view, never()).showInvalidPassword()
    }

    @Test
    fun `When the Repeat Password is Invalid` () {
        doReturn(false).`when`(validatorInterface).isValidRepassword(any(), any())
        presenter.validateRepassword("xptp", "xpto")
        verify(view).showInvalidRepassword()
    }

    @Test
    fun `When the Repeat Password is Valid` () {
        doReturn(true).`when`(validatorInterface).isValidRepassword(any(), any())
        presenter.validateRepassword("xpto", "xpto")
        verify(view, never()).showInvalidRepassword()
    }

    @Test
    fun `When the form is invalid`(){
        doReturn(false).`when`(validatorInterface).isValidForm(any())
        presenter.validateForm()
        verify(view).showInvalidForm()
    }

    @Test
    fun `When the form is valid` (){
        doReturn(true).`when`(validatorInterface).isValidForm(any())
        presenter.validateForm()
        verify(view, never()).showInvalidForm()
    }

}