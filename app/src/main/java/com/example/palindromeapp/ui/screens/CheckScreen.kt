package com.example.palindromeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.palindromeapp.viewmodel.PalindromeViewModel

@Composable
fun CheckScreen(viewModel: PalindromeViewModel = hiltViewModel()) {
    var word by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {

        OutlinedTextField(value = word, onValueChange = { word = it }, label = { Text("Enter a word") })
        Button(onClick = { viewModel.checkWord(word) }) {
            Text("Check")
        }

        viewModel.isPalindrome?.let {
            Text(if (it) "✅ It's a palindrome!" else "❌ Not a palindrome")
        }
    }
}