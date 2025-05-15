package com.example.palindromeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.palindromeapp.data.PalindromeRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

@HiltViewModel
class PalindromeViewModel @Inject constructor(
    private val repo: PalindromeRepositoryInterface
) : ViewModel() {

    var isPalindrome by mutableStateOf<Boolean?>(null)
        private set

    val palindromes = repo.getPalindromes().stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    fun checkWord(word: String) {
        viewModelScope.launch {
            isPalindrome = repo.checkAndSave(word)
        }
    }
}

