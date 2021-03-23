package br.com.jvprogramador.awaycard

class UserRegister {
    fun execute(nickname: String): Boolean {
        return isNicknameEmpty(nickname) && hasNicknameValid(nickname)
    }

    private fun hasNicknameValid(nickname: String) = nickname.length >= 4

    private fun isNicknameEmpty(nickname: String) = nickname.isNotEmpty()
}
