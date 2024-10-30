package com.example.lab12


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab12.ui.theme.Lab12Theme

@Composable
fun ColorChangeAnimation() {
    var isGreen by remember { mutableStateOf(false) }

    // Definimos el color de fondo usando animateColorAsState
    val backgroundColor by animateColorAsState(
        targetValue = if (isGreen) Color.Green else Color.Blue,
        animationSpec = tween(durationMillis = 1000) // Puedes cambiar a spring o probar otros valores
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
                .size(150.dp)
                .background(backgroundColor) // Aplicamos el color animado aquí
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { isGreen = !isGreen }) {
            Text("Cambiar Color")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorChangeAnimationPreview() {
    Lab12Theme {
        ColorChangeAnimation()
    }
}


