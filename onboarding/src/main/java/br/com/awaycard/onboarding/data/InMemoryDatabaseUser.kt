package br.com.awaycard.onboarding.data

import javax.inject.Inject

class InMemoryDatabaseUser @Inject constructor(private val appDatabase: AppDatabase) : InLocalService {
    override suspend fun insert(nickname: String) {
        if (nickname.isNotEmpty()) {
            return appDatabase.userRegisterDAO().insert(User(nickname = nickname))
        } else {
            throw IllegalArgumentException()
        }
    }

    override suspend fun get(): String {
        return appDatabase.userRegisterDAO().getAll().first().nickname
    }

    fun onClose() {
        appDatabase.close()
    }
}