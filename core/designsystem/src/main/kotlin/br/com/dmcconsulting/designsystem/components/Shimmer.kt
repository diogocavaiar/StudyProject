package br.com.dmcconsulting.designsystem.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import br.com.dmcconsulting.designsystem.extensions.backgroundLinearGradientBrush

/**
 * Composable function representing a linear shimmer effect.
 *
 * @param modifier Optional modifier for the layout.
 */
@Composable
fun FieldLinearShimmer(
    modifier: Modifier
) {
    // Animation for shimmer effect
    val translateAnim = animateTransitionFloat()
    val end = Offset(x = translateAnim.value, y = translateAnim.value)

    // Displaying the shimmer effect
    Spacer(
        modifier = modifier
            .backgroundLinearGradientBrush(end = end)
    )
}

