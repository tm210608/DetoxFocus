package com.tonidev.detoxfocus.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

// La app siempre usa modo oscuro (regla del PRD: "negro absoluto profundo"),
// independientemente del tema del sistema.
private val DetoxFocusColorScheme = darkColorScheme(
    background = BackgroundBlack,
    surface = CardSurface,
    primary = AccentProgress,
    error = AccentAlert,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onPrimary = BackgroundBlack,
    secondary = TextSecondary
)

@Composable
fun DetoxFocusTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DetoxFocusColorScheme,
        typography = DetoxFocusTypography,
        content = content
    )
}