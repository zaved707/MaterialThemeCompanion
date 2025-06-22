package com.zavedahmad.materialColorsCompanion.utility


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getInverseColor(color: Color): Color {
    return Color(
        red = 1f - color.red,
        green = 1f - color.green,
        blue = 1f - color.blue,
        alpha = color.alpha // Preserve the original alpha
    )
}