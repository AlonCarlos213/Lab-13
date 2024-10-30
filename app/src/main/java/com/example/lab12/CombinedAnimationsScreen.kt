package com.example.lab12

import androidx.compose.animation.*
import androidx.compose.animation.core.*
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
fun CombinedAnimationsScreen() {
    // Estado para controlar el color y tamaño del cuadro
    var isLarge by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(true) }
    var isLightMode by remember { mutableStateOf(true) }

    // Animación de color y tamaño del cuadro
    val boxColor by animateColorAsState(
        targetValue = if (isLightMode) Color(0xFFBB86FC) else Color(0xFF6200EE),
        animationSpec = tween(durationMillis = 800)
    )
    val boxSize by animateDpAsState(
        targetValue = if (isLarge) 200.dp else 100.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    // Animación para cambiar entre el contenido de modos
    val backgroundColor by animateColorAsState(
        targetValue = if (isLightMode) Color.White else Color.Black,
        animationSpec = tween(durationMillis = 800)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Cuadro que cambia de color y tamaño al hacer clic
            Box(
                modifier = Modifier
                    .size(boxSize)
                    .background(boxColor)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para cambiar el tamaño y el color del cuadro
            Button(onClick = { isLarge = !isLarge }) {
                Text("Cambiar Tamaño y Color")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para alternar visibilidad
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(1000)),
                exit = fadeOut(animationSpec = tween(1000))
            ) {
                Button(onClick = { isVisible = !isVisible }) {
                    Text("Desaparecer")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para alternar entre modo claro y oscuro
            Button(onClick = { isLightMode = !isLightMode }) {
                Text("Alternar Modo Claro/Oscuro")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CombinedAnimationsScreenPreview() {
    Lab12Theme {
        CombinedAnimationsScreen()
    }
}
