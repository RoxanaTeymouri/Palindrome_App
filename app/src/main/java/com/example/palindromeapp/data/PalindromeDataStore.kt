package com.example.palindromeapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit

class PalindromeDataStore(private val dataStore: DataStore<Preferences>) {
    private val key = stringSetPreferencesKey("palindromes")

    val savedPalindromes: Flow<Set<String>> = dataStore.data
        .map { it[key] ?: emptySet() }

    suspend fun savePalindrome(word: String) {
        dataStore.edit { prefs ->
            val current = prefs[key]?.toMutableSet() ?: mutableSetOf()
            current.add(word)
            prefs[key] = current
        }
    }
}
