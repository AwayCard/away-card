package br.com.awaycard.data

class InMemoryUserRegister(private val appDatabase: AppDatabase) {
    suspend fun insert(nickname: String) {
        if (nickname.isNotEmpty()) {
            return appDatabase.userRegisterDAO().insert(User(nickname = nickname))
        } else {
            throw IllegalArgumentException()
        }
    }

    suspend fun get(): String {
        return appDatabase.userRegisterDAO().getAll().first().nickname
    }

    fun onClose() {
        appDatabase.close()
    }
}