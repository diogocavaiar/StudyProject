package br.com.dmcconsulting.designsystem.extensions

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

/**
 * Utility function to create a linear gradient brush for drawing backgrounds.
 *
 * @param start The starting offset of the gradient.
 * @param end The ending offset of the gradient.
 * @param tileMode The tiling mode for the gradient.
 * @param colors The list of colors to be used in the gradient.
 * @return A [Brush] object representing the linear gradient brush.
 */
private fun linearGradientBrush(
    start: Offset = Offset.Zero,
    end: Offset = Offset.Infinite,
    tileMode: TileMode = TileMode.Clamp,
    colors: List<Color> = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )
): Brush {
    return Brush.linearGradient(
        colors = colors,
        start = start,
        end = end,
        tileMode = tileMode
    )
}

/**
 * Extension function for Modifier to apply a linear gradient brush as background.
 *
 * @param end The ending offset of the gradient.
 * @return Modified Modifier object with the linear gradient brush applied as background.
 */
fun Modifier.backgroundLinearGradientBrush(end: Offset): Modifier = this.then(background(
    linearGradientBrush(end)
))
