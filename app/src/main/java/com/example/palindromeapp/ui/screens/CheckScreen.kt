package com.example.palindromeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.palindromeapp.R
import com.example.palindromeapp.viewmodel.PalindromeViewModel

@Composable
fun CheckScreen(viewModel: PalindromeViewModel = hiltViewModel()) {
    var word by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = word,
            onValueChange = { word = it },
            label = { Text(stringResource(R.string.enter_a_word)) })
        Button(onClick = { viewModel.validateAndSave(word) }) {
            Text(stringResource(R.string.check))
        }
        viewModel.isPalindrome?.let {
            Text(if (it) stringResource(R.string.it_s_a_palindrome) else stringResource(R.string.not_a_palindrome))
        }
    }
}