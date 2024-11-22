package project.yugandhar_kumar.textdrawinganimation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun AnimatedWord(word: String, onLetterClick: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        word.forEachIndexed { index, letter ->
            AnimatedLetter(
                letter = letter.toString(),
                delayMillis = index * 500L,
                onClick = { onLetterClick(letter.toString()) }
            )
        }
    }
}