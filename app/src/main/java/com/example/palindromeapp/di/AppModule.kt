package com.example.palindromeapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.example.palindromeapp.data.PalindromeDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import androidx.datastore.preferences.core.Preferences
import javax.inject.Singleton
import com.example.palindromeapp.data.PalindromeRepository


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            context.dataStoreFile("palindromes.preferences_pb")
        }
    }

    @Provides
    @Singleton
    fun provideRepository(dataStore: DataStore<Preferences>): PalindromeRepository {
        return PalindromeRepository(PalindromeDataStore(dataStore))
    }
}
