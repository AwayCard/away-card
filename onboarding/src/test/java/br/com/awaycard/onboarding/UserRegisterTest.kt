package br.com.awaycard.onboarding

import br.com.awaycard.onboarding.viewmodel.UserRegister
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

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