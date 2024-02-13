package br.com.dmcconsulting.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val DefaultSpace = 0.dp
private val ExtraSmallSpace = 4.dp
private val SmallSpace = 8.dp
private val SmallMediumSpace = 12.dp
private val MediumSpace = 16.dp
private val ExtraMediumSpace = 24.dp
private val LargeSpace = 32.dp
private val MediumLargeSpace = 40.dp
private val ExtraLargeSpace = 48.dp
private val LargestSpace = 64.dp
private val Space160 = 160.dp
private val Space180 = 180.dp
private val Space200 = 200.dp
private val Space400 = 400.dp

@Immutable
data class DmcSpacing(
    val default: Dp = DefaultSpace,
    val extraSmall: Dp = ExtraSmallSpace,
    val small: Dp = SmallSpace,
    val smallMedium: Dp = SmallMediumSpace,
    val medium: Dp = MediumSpace,
    val extraMedium: Dp = ExtraMediumSpace,
    val large: Dp = LargeSpace,
    val mediumLarge: Dp = MediumLargeSpace,
    val extraLarge: Dp = ExtraLargeSpace,
    val largest: Dp = LargestSpace,
    val space160: Dp = Space160,
    val space180: Dp = Space180,
    val space200: Dp = Space200,
    val space400: Dp = Space400,
)

internal val LocalDmcSpacing = staticCompositionLocalOf { DmcSpacing() }
