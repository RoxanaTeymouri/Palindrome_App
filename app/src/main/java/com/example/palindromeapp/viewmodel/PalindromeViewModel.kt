package com.example.palindromeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import com.example.palindromeapp.domain.CheckPalindromeUseCase
import com.example.palindromeapp.domain.GetPalindromeUseCase
import com.example.palindromeapp.domain.SavePalindromeUseCase

@HiltViewModel
class PalindromeViewModel @Inject constructor(
    private val savePalindromeUseCase: SavePalindromeUseCase,
    private val checkPalindromeUseCase: CheckPalindromeUseCase,
    getPalindromeUseCase: GetPalindromeUseCase
) : ViewModel() {

    var isPalindrome by mutableStateOf<Boolean?>(null)
        private set

    val palindromes = getPalindromeUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun validateAndSave(word: String) {
        if (checkPalindromeUseCase(word)) {
            viewModelScope.launch {
                savePalindromeUseCase(word)
            }
            isPalindrome = true
        } else {
            isPalindrome = false
        }
    }
}


