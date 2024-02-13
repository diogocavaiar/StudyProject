import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import br.com.dmcconsulting.designsystem.theme.DmcTheme

/**
 * Composable function for displaying small headlines.
 *
 * @param text The text to display.
 * @param modifier Optional modifier for the text layout.
 * @param color The color of the text.
 * @param textAlign The alignment of the text within its layout.
 * @param maxLines The maximum number of lines to allow before truncating.
 * @param overflow The behavior to use when the text overflows its layout bounds.
 */
@Composable
fun HeadlineSmallText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        style = DmcTheme.typography.headlineSmall,
    )
}

/**
 * Composable function for displaying large titles.
 *
 * @param text The text to display.
 * @param modifier Optional modifier for the text layout.
 * @param color The color of the text.
 * @param textAlign The alignment of the text within its layout.
 * @param maxLines The maximum number of lines to allow before truncating.
 * @param overflow The behavior to use when the text overflows its layout bounds.
 */
@Composable
fun TitleLargeText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        style = DmcTheme.typography.titleLarge,
    )
}

/**
 * Composable function for displaying large body text.
 *
 * @param text The text to display.
 * @param modifier Optional modifier for the text layout.
 * @param color The color of the text.
 * @param textAlign The alignment of the text within its layout.
 * @param maxLines The maximum number of lines to allow before truncating.
 * @param overflow The behavior to use when the text overflows its layout bounds.
 */
@Composable
fun BodyLargeText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        style = DmcTheme.typography.bodyLarge,
    )
}

/**
 * Composable function for displaying large label text.
 *
 * @param text The text to display.
 * @param modifier Optional modifier for the text layout.
 * @param color The color of the text.
 * @param textAlign The alignment of the text within its layout.
 * @param maxLines The maximum number of lines to allow before truncating.
 * @param overflow The behavior to use when the text overflows its layout bounds.
 */
@Composable
fun LabelLargeText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        style = DmcTheme.typography.labelLarge,
    )
}

/**
 * Composable function for displaying medium label text.
 *
 * @param text The text to display.
 * @param modifier Optional modifier for the text layout.
 * @param color The color of the text.
 * @param textAlign The alignment of the text within its layout.
 * @param maxLines The maximum number of lines to allow before truncating.
 * @param overflow The behavior to use when the text overflows its layout bounds.
 */
@Composable
fun LabelMediumText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        style = DmcTheme.typography.labelMedium,
    )
}
