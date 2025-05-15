package com.example.palindromeapp.data


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PalindromeRepository(private val store: PalindromeDataStore) {
    fun getPalindromes(): Flow<List<String>> =
        store.savedPalindromes.map { it.toList() }

    suspend fun checkAndSave(word: String): Boolean {
        val clean = word.trim().lowercase()
        val isPalindrome = clean == clean.reversed()
        if (isPalindrome) {
            store.savePalindrome(word)
        }
        return isPalindrome
    }
}
