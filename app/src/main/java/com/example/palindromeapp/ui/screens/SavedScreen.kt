package com.example.palindromeapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.palindromeapp.viewmodel.PalindromeViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue

@Composable
fun SavedScreen(viewModel: PalindromeViewModel = hiltViewModel()) {
    val list by viewModel.palindromes.collectAsState()

    LazyColumn(Modifier.padding(16.dp)) {
        items(list) { word ->
            Text(word, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
