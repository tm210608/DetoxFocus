package com.tonidev.detoxfocus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tonidev.detoxfocus.presentation.screens.dashboard.DashboardScreen
import com.tonidev.detoxfocus.presentation.theme.DetoxFocusTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DetoxFocusContent()
        }
    }
}

@Composable
private fun DetoxFocusContent() {
    DetoxFocusTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            // Punto de entrada temporal: de momento solo el dashboard.
            // MÓDULO SIGUIENTE: sustituir por NavHost con rutas dashboard/lockscreen/habits.
            DashboardScreen()
        }
    }
}