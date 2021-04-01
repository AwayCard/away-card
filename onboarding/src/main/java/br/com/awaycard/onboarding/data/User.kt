package br.com.awaycard.onboarding.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int = PK_INITIAL_VALUE,
    @ColumnInfo(name = "nickname") val nickname: String
) {
    companion object {
        const val PK_INITIAL_VALUE = 0
    }
}