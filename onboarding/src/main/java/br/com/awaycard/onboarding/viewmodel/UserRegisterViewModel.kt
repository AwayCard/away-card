package br.com.awaycard.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import br.com.awaycard.onboarding.data.InLocalService

class UserRegisterViewModel(private val inMemoryUser: InLocalService) : ViewModel() {

    suspend fun execute(nickname: String): Boolean {
        if (isNicknameEmpty(nickname) && hasNicknameValid(nickname)) {
            inMemoryUser.insert(nickname)
            return true
        }
        return false
    }

    private fun hasNicknameValid(nickname: String) = nickname.length >= 4

    private fun isNicknameEmpty(nickname: String) = nickname.isNotEmpty()
}
