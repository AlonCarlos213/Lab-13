package com.example.lab12

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab12.ui.theme.Lab12Theme

enum class ContentState {
    LOADING, CONTENT, ERROR
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExample() {
    var currentState by remember { mutableStateOf(ContentState.LOADING) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedContent(
            targetState = currentState,
            transitionSpec = {
                fadeIn(animationSpec = tween(600)) with fadeOut(animationSpec = tween(600))
            }
        ) { state ->
            when (state) {
                ContentState.LOADING -> Text("Cargando...")
                ContentState.CONTENT -> Text("Contenido cargado exitosamente")
                ContentState.ERROR -> Text("Error al cargar el contenido")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón para cambiar entre estados
        Button(onClick = {
            currentState = when (currentState) {
                ContentState.LOADING -> ContentState.CONTENT
                ContentState.CONTENT -> ContentState.ERROR
                ContentState.ERROR -> ContentState.LOADING
            }
        }) {
            Text("Cambiar Estado")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedContentExamplePreview() {
    Lab12Theme {
        AnimatedContentExample()
    }
}
