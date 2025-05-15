package com.example.palindromeapp.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPalindromeUseCase @Inject constructor(
    private val repo: PalindromeRepository
) {
    operator fun invoke(): Flow<List<String>> =
        repo.getPalindromes()
}