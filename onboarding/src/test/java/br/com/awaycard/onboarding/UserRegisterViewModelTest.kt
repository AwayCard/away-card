package br.com.awaycard.onboarding

import br.com.awaycard.onboarding.viewmodel.UserRegisterViewModel
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserRegisterViewModelTest {
    private val userRegister by lazy { UserRegisterViewModel() }

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