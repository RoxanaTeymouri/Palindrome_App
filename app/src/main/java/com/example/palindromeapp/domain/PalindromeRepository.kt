package com.example.palindromeapp.domain

import kotlinx.coroutines.flow.Flow

interface PalindromeRepository {
    fun getPalindromes(): Flow<List<String>>
    suspend fun savePalindrome(word: String)
}