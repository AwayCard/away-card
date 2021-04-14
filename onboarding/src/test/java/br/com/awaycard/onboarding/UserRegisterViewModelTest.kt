package br.com.awaycard.onboarding

import br.com.awaycard.onboarding.data.InLocalService
import br.com.awaycard.onboarding.viewmodel.UserRegisterViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserRegisterViewModelTest {
    private val userRegister by lazy { UserRegisterViewModel(InLocalMemoryTest()) }

    @Test fun registerUser() = runBlocking {
        assertTrue(userRegister.execute("jvprogramador"))
    }

    @Test fun registerUserWithoutNickname() = runBlocking {
        assertFalse(userRegister.execute(""))
    }

    @Test fun registerUserMoreOrEqualsFourCharacters() = runBlocking {
        assertFalse(userRegister.execute("jv"))
    }
}

class InLocalMemoryTest : InLocalService {
    private var nickname = ""

    override suspend fun insert(nickname: String) {
        this.nickname = nickname
    }

    override suspend fun get(): String {
        return nickname
    }

}
