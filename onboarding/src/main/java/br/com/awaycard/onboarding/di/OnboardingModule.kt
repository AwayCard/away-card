package br.com.awaycard.onboarding.di

import android.content.Context
import androidx.room.Room
import br.com.awaycard.onboarding.data.AppDatabase
import br.com.awaycard.onboarding.data.InLocalService
import br.com.awaycard.onboarding.data.InMemoryDatabaseUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
internal object OnboardingModule {
    @Provides
    @ViewModelScoped
    fun provideInMemoryDatabase(db: AppDatabase): InLocalService = InMemoryDatabaseUser(db)

    @Provides
    @ViewModelScoped
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "awaycard-db").build()
    }
}