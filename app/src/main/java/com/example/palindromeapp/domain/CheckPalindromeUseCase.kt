package com.example.palindromeapp.domain

import javax.inject.Inject

class CheckPalindromeUseCase @Inject constructor() {
    operator fun invoke(word: String): Boolean {
        val clean = word.trim().lowercase()
        return clean == clean.reversed()
    }
}