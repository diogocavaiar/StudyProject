package br.com.dmcconsulting.designsystem.components

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

/**
 * Composable function for animating a transition of Float values.
 *
 * @param initialValue The initial value of the animation.
 * @param targetValue The target value of the animation.
 * @param durationMillis The duration of the animation in milliseconds.
 * @param easing The easing curve to be used for the animation.
 * @param repeatMode The repeat mode for the animation.
 * @param label A label to identify this animation.
 * @return [State] object representing the current value of the animation.
 */
@Composable
fun animateTransitionFloat(
    initialValue: Float = 0f,
    targetValue: Float = 1000f,
    durationMillis: Int = 1000,
    easing: Easing = FastOutSlowInEasing,
    repeatMode: RepeatMode = RepeatMode.Reverse,
    label: String = ""
): State<Float> {
    val transition = rememberInfiniteTransition(label = label)
    return transition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = easing
            ),
            repeatMode = repeatMode
        ),
        label = label
    )
}
