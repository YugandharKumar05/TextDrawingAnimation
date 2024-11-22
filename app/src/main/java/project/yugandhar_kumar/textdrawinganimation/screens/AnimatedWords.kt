package project.yugandhar_kumar.textdrawinganimation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimatedWords() {
    var selectedLetters by remember { mutableStateOf(listOf<String>()) }
    var isCardVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            listOf("ARIQT", "INTERNATIONAL", "A", "Developers", "First", "Company").forEach { word ->
                AnimatedWord(word = word) { letter ->
                    selectedLetters = selectedLetters + letter
                    isCardVisible = true
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }

        if (isCardVisible) {
            SelectedLettersCard(letters = selectedLetters, onDismiss = {
                isCardVisible = false
                selectedLetters = emptyList()
            })
        }
    }
}