package com.leonardo.study.login.user

import com.nhaarman.mockitokotlin2.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRepositoryTest {

    @Mock private lateinit var dao: UserDAO

    private lateinit var repository: UserRepository

    @Before
    fun setUp() {
        repository = UserRepository(dao)
    }

    @Test
    fun `Verify if the getAll method as called` () {
        repository.getAll()
        verify(dao).getAll()
    }

    @Test
    fun `Verify if the user is added to db`() {
        val user: User = mock()
        repository.insert(user)
        verify(dao).insert(eq(user))
    }

    @Test
    fun `Verify if the id is updated in the user after adding to the db` () {
        doReturn(10L).`when`(dao).insert(any())
        val user: User = spy(User())
        repository.insert(user)
        verify(dao).insert(eq(user))
        Assert.assertEquals(10L, user.id)
    }

    @Test
    fun `Verify if the checkpassword method was called` () {
        repository.checkPassword("xpto", "xpto")
        verify(dao).checkPassword(eq("xpto"), eq("xpto"))
    }

    @Test
    fun `Verify if the selectUserById method was called` () {
        repository.selectUserById(any())
        verify(dao).selectUserById(any())
    }

    @Test
    fun `Verify if the deleteUser method was called` (){
        val user: User = spy(User())
        repository.deleteUser(user)
        verify(dao).delete(user)
    }

    @Test
    fun `Verify if the update method was called` () {
        val user: User = spy(User())
        repository.update(user)
        verify(dao).update(user)
    }
}