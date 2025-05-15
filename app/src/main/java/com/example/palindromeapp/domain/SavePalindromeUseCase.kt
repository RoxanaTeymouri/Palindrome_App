package com.example.palindromeapp.domain

import javax.inject.Inject

class SavePalindromeUseCase @Inject constructor(
    private val repo: PalindromeRepository
) {
    suspend operator fun invoke(word: String) {
        repo.savePalindrome(word)
    }
}