package br.com.dmcconsulting.designsystem.components

import BodyLargeText
import LabelMediumText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import br.com.dmcconsulting.designsystem.theme.DmcTheme

/**
 * Composable function for displaying a profile icon using an asynchronous image loader.
 *
 * @param path The URL or local path of the image to be displayed.
 */
@Composable
fun ProfileIcon(
    path: String
) {
    AsyncImageCoil(
        model = path,
        modifier = Modifier
            .clip(CircleShape)
            .size(DmcTheme.spacing.largest)
    )
}

/**
 * Composable function to display a title with a subtitle in a column layout.
 *
 * @param title The main title text to be displayed using a large body text style.
 * @param subTitle The subtitle text to be displayed below the title using a medium label text style.
 * @param modifier An optional [Modifier] to apply to the entire column layout.
 */
@Composable
fun ColumnWithTitleAndSubtitle(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        BodyLargeText(text = title)
        LabelMediumText(text = subTitle)
    }
}

/**
 * Composable function to display a complete profile section, including a profile icon,
 * a main title, and a subtitle, arranged in a horizontal row.
 *
 * @param path The path to the profile icon image.
 * @param title The main title text to be displayed using a large body text style.
 * @param subTitle The subtitle text to be displayed below the title using a medium label text style.
 * @param modifier An optional [Modifier] to apply to the entire profile section.
 */
@Composable
fun CompleteProfileSection(
    path: String,
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        ProfileIcon(
            path = path,
        )
        ColumnWithTitleAndSubtitle(
            title = title,
            subTitle = subTitle,
            modifier = Modifier
                .padding(start = DmcTheme.spacing.small)
                .align(Alignment.CenterVertically)
        )
    }
}