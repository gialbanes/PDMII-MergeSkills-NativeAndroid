package com.fatec.merge_skills.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val MergeSkillsColorScheme = darkColorScheme(
    primary = StitchGreen,
    onPrimary = Color.Black,
    primaryContainer = StitchGreenContainer,
    onPrimaryContainer = Color.White,
    secondary = StitchGreenDark,
    onSecondary = Color.White,
    background = Background,
    onBackground = OnSurface,
    surface = Surface,
    onSurface = OnSurface,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurface,
    error = StitchError,
    onError = Color.White
)

@Composable
fun MergeskillskotlinTheme(
    // Merge Skills is Dark Mode by design
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MergeSkillsColorScheme,
        typography = Typography,
        content = content
    )
}