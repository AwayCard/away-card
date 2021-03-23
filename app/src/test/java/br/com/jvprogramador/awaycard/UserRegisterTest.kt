package br.com.jvprogramador.awaycard

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UserRegisterTest {
    private val userRegister by lazy { UserRegister() }

    @Test fun registerUser() {
        assertTrue(userRegister.execute("jvprogramador"))
    }

    @Test fun registerUserWithoutNickname() {
        assertFalse(userRegister.execute(""))
    }

    @Test fun registerUserMoreOrEqualsFourCharacters() {
        assertFalse(userRegister.execute("jv"))
    }
}