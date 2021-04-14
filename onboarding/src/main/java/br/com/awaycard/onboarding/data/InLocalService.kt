package br.com.awaycard.onboarding.data

interface InLocalService {
    suspend fun insert(nickname: String)
    suspend fun get(): String
}
