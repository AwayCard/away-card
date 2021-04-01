package br.com.awaycard.onboarding.viewmodel

import androidx.lifecycle.ViewModel

class UserRegisterViewModel : ViewModel() {
    fun execute(nickname: String): Boolean {
        return isNicknameEmpty(nickname) && hasNicknameValid(nickname)
    }

    private fun hasNicknameValid(nickname: String) = nickname.length >= 4

    private fun isNicknameEmpty(nickname: String) = nickname.isNotEmpty()
}
