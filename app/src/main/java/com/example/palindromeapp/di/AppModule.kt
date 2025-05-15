package com.example.palindromeapp.di


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.example.palindromeapp.data.PalindromeDataStore
import com.example.palindromeapp.data.PalindromeRepositoryImpl
import com.example.palindromeapp.domain.PalindromeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindPalindromeRepository(
        repo: PalindromeRepositoryImpl
    ): PalindromeRepository

    companion object {
        @Provides
        @Singleton
        fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
            return PreferenceDataStoreFactory.create {
                context.dataStoreFile("palindromes.preferences_pb")
            }
        }

        @Provides
        @Singleton
        fun providePalindromeDataStore(
            dataStore: DataStore<Preferences>
        ): PalindromeDataStore {
            return PalindromeDataStore(dataStore)
        }
    }
}

