package com.example.palindromeapp.data


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PalindromeRepository @Inject constructor(
    private val store: PalindromeDataStore
) : PalindromeRepositoryInterface {

    override fun getPalindromes(): Flow<List<String>> =
        store.savedPalindromes.map { it.toList() }

    override suspend fun checkAndSave(word: String): Boolean {
        val clean = word.trim().lowercase()
        val isPalindrome = clean == clean.reversed()
        if (isPalindrome) {
            store.savePalindrome(word)
        }
        return isPalindrome
    }
}

