package project.yugandhar_kumar.textdrawinganimation.screens

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun SelectedLettersCard(letters: List<String>, onDismiss: () -> Unit) {
    val density = LocalDensity.current
    val transitionState = remember { MutableTransitionState(false) }
    transitionState.targetState = true

    val offsetY by updateTransition(transitionState, label = "CardTransition")
        .animateDp(
            transitionSpec = { tween(durationMillis = 1000, easing = LinearOutSlowInEasing) },
            label = "CardOffsetY"
        ) { state ->
            if (state) with(density) { 200.dp } else with(density) { -200.dp }
        }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .offset(y = offsetY)
            .pointerInput(Unit) {
                detectTapGestures(onTap = { onDismiss() })
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            letters.forEach { letter ->
                AnimatedLetterInCard(letter = letter)
            }
        }
    }
}
