package project.yugandhar_kumar.textdrawinganimation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedWord(word: String, onLetterClick: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
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