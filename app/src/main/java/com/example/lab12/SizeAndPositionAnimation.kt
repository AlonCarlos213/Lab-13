package com.example.lab12

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab12.ui.theme.Lab12Theme

@Composable
fun SizeAndPositionAnimation() {
    var isExpanded by remember { mutableStateOf(false) }

    // Animamos el tamaño del cuadro
    val size by animateDpAsState(
        targetValue = if (isExpanded) 150.dp else 50.dp,
        animationSpec = tween(durationMillis = 500)
    )

    // Animamos la posición usando offset
    val offsetX by animateDpAsState(
        targetValue = if (isExpanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )
    val offsetY by animateDpAsState(
        targetValue = if (isExpanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(size) // Ajusta el tamaño
                .offset(x = offsetX, y = offsetY) // Ajusta la posición
                .background(Color.Red) // Color de fondo del cuadro
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { isExpanded = !isExpanded }) {
            Text("Mover y Cambiar Tamaño")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SizeAndPositionAnimationPreview() {
    Lab12Theme {
        SizeAndPositionAnimation()
    }
}

