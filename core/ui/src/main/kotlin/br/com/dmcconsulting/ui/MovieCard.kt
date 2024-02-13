package br.com.dmcconsulting.ui

import LabelLargeText
import LabelMediumText
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import br.com.dmcconsulting.designsystem.components.AsyncImageCoil
import br.com.dmcconsulting.designsystem.components.FieldLinearShimmer
import br.com.dmcconsulting.designsystem.theme.DmcTheme

/**
 * Composable function for displaying a movie card with details.
 *
 * @param urlImage The URL of the movie image.
 * @param name The name of the movie.
 * @param year The release year of the movie.
 * @param id The unique identifier of the movie.
 * @param onItemClick Callback for handling the click event on the movie card.
 * @param modifier The modifier for customizing the layout.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(
    urlImage: String,
    name: String,
    year: String,
    id: Int,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        onClick = { onItemClick(id) },
        modifier = modifier
            .wrapContentHeight()
            .width(DmcTheme.spacing.space160)
            .testTag("movie_card_tag")
    ) {
        AsyncImageCoil(
            model = urlImage,
            modifier = Modifier
                .height(DmcTheme.spacing.space180)
                .clip(DmcTheme.shapes.customZeroZeroTwelveTwelve)
                .testTag("movie_card_image_tag")
        )
        LabelLargeText(
            text = name,
            modifier = Modifier
                .padding(top = DmcTheme.spacing.small, start = DmcTheme.spacing.small)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .testTag("movie_card_large_text_tag"),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        LabelMediumText(
            text = year,
            modifier = Modifier
                .padding(
                    top = DmcTheme.spacing.extraSmall,
                    start = DmcTheme.spacing.small,
                    bottom = DmcTheme.spacing.small
                )
                .wrapContentHeight(align = Alignment.CenterVertically)
                .testTag("movie_card_label_small_tag"),
        )
    }
}

/**
 * Composable function for displaying a shimmer effect for a loading movie card.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShimmerMovieCard() {
    ElevatedCard(
        onClick = { },
        modifier = Modifier
            .padding(start = DmcTheme.spacing.medium)
            .wrapContentHeight()
            .width(DmcTheme.spacing.space160)
            .testTag("movie_card_tag")
    ) {
        FieldLinearShimmer(
            modifier = Modifier
                .height(DmcTheme.spacing.space180)
                .fillMaxWidth()
                .clip(DmcTheme.shapes.customZeroZeroTwelveTwelve)
        )
        FieldLinearShimmer(
            modifier = Modifier
                .padding(top = DmcTheme.spacing.small, start = DmcTheme.spacing.small)
                .height(DmcTheme.spacing.large)
                .fillMaxWidth(fraction = 0.9f)
                .clip(DmcTheme.shapes.smallMedium)
        )
        FieldLinearShimmer(
            Modifier
                .padding(
                    top = DmcTheme.spacing.extraSmall,
                    start = DmcTheme.spacing.small,
                    bottom = DmcTheme.spacing.small
                )
                .height(DmcTheme.spacing.large)
                .fillMaxWidth(fraction = 0.4f)
                .clip(DmcTheme.shapes.smallMedium)
        )
    }
}