package com.example.palindromeapp.data


import kotlinx.coroutines.flow.Flow

interface PalindromeRepositoryInterface {
    fun getPalindromes(): Flow<List<String>>
    suspend fun checkAndSave(word: String): Boolean
}
