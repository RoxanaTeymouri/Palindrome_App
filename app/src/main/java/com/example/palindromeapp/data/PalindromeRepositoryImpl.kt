package com.example.palindromeapp.data

import com.example.palindromeapp.domain.PalindromeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PalindromeRepositoryImpl @Inject constructor(
    private val store: PalindromeDataStore
) : PalindromeRepository {

    override fun getPalindromes(): Flow<List<String>> =
        store.savedPalindromes.map { it.toList() }

    override suspend fun savePalindrome(word: String) {
        store.savePalindrome(word)
    }
}