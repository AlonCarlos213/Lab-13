package com.example.lab12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab12.ui.theme.Lab12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab12Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var currentExample by remember { mutableStateOf(1) }

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Botón para alternar entre los ejemplos de animación
                        Button(onClick = {
                            currentExample = (currentExample % 5) + 1 // Actualizado para 5 ejemplos
                        }) {
                            Text("Cambiar Ejemplo de Animación")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        // Mostrar el ejemplo según el estado
                        when (currentExample) {
                            1 -> AnimatedVisibilityExample()
                            2 -> ColorChangeAnimation()
                            3 -> SizeAndPositionAnimation()
                            4 -> AnimatedContentExample()
                            5 -> CombinedAnimationsScreen() // Ejercicio Final de Animaciones Combinadas
                        }
                    }
                }
            }
        }
    }
}
