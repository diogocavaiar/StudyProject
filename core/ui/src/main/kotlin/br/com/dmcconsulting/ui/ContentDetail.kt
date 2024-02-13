package br.com.dmcconsulting.ui

import BodyLargeText
import HeadlineSmallText
import TitleLargeText
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.captionBar
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import br.com.dmcconsulting.designsystem.components.AsyncImageCoil
import br.com.dmcconsulting.designsystem.components.CompleteProfileSection
import br.com.dmcconsulting.designsystem.components.SectionRowPeople
import br.com.dmcconsulting.designsystem.icon.DmcIcons
import br.com.dmcconsulting.designsystem.theme.DmcTheme
import br.com.dmcconsulting.model.data.Cast
import br.com.dmcconsulting.model.data.Crew
import br.com.dmcconsulting.model.data.MovieDetails

/**
 * Composable function for displaying detailed content, including movie details and cast information.
 *
 * @param data The [MovieDetails] object containing information about the movie.
 * @param onClickBackButton Callback for handling the click event on the back button.
 * @param onClickFavorite Callback for handling the click event on the favorite icon.
 * @param modifier The modifier for customizing the layout.
 */
@Composable
fun ContentDetail(
    data: MovieDetails,
    onClickBackButton: () -> Unit,
    onClickFavorite: (MovieDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {
            val (backdropRef, posterRef, detailRef, favoriteRef) = createRefs()
            val backdropHeight = DmcTheme.spacing.space400
            TopComponent(backdropRef, backdropHeight, data, onClickBackButton)
            FavoriteIcon(favoriteRef, backdropRef) {
                onClickFavorite(data)
            }
            PosterCard(posterRef, favoriteRef, backdropHeight, data.posterPath)
            DetailMovie(detailRef, favoriteRef, posterRef, data)
        }
        Synopsis(
            overview = data.overview,
            modifier = Modifier.padding(horizontal = DmcTheme.spacing.medium)
        )
        ListCast(
            casts = data.credits.cast,
            modifier = Modifier.padding(
                start = DmcTheme.spacing.small,
                end = DmcTheme.spacing.small,
                bottom = DmcTheme.spacing.medium
            )
        )
        ListCrew(
            crews = data.credits.crew,
            modifier = Modifier.padding(
                start = DmcTheme.spacing.small,
                end = DmcTheme.spacing.small,
                bottom = DmcTheme.spacing.medium
            )
        )
    }
}

/**
 * Composable function for displaying a list of cast members.
 *
 * @param casts The list of [Cast] objects representing the cast members.
 * @param modifier The modifier for customizing the layout.
 */
@Composable
private fun ListCast(
    casts: List<Cast>,
    modifier: Modifier = Modifier
) {
    SectionRowPeople(
        section = "Casts",
        items = casts,
        content = { cast ->
            CompleteProfileSection(
                path = cast.profilePath.orEmpty(),
                title = cast.name,
                subTitle = cast.character,
                modifier = Modifier.padding(horizontal = DmcTheme.spacing.small)
            )
        },
        modifier = modifier
    )
}

/**
 * Composable function for displaying a list of crew members.
 *
 * @param crews The list of [Crew] objects representing the crew members.
 * @param modifier The modifier for customizing the layout.
 */
@Composable
private fun ListCrew(
    crews: List<Crew>,
    modifier: Modifier = Modifier
) {
    SectionRowPeople(
        section = "Crews",
        items = crews,
        content = { crew ->
            CompleteProfileSection(
                path = crew.profilePath.orEmpty(),
                title = crew.name,
                subTitle = crew.job,
                modifier = Modifier.padding(horizontal = DmcTheme.spacing.small)
            )
        },
        modifier = modifier
    )
}

/**
 * Composable function for displaying a synopsis of the movie.
 *
 * @param overview The movie overview text.
 * @param modifier The modifier for customizing the layout.
 */
@Composable
private fun Synopsis(
    overview: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        HeadlineSmallText(
            text = "Synopsis",
            modifier = Modifier.padding(top = DmcTheme.spacing.medium)
        )
        BodyLargeText(
            text = overview,
            modifier = Modifier.padding(top = DmcTheme.spacing.small)
        )
    }
}

/**
 * Composable function for displaying detailed movie information.
 *
 * @param detailRef The [ConstrainedLayoutReference] for the detail component.
 * @param favoriteRef The [ConstrainedLayoutReference] for the favorite icon.
 * @param posterRef The [ConstrainedLayoutReference] for the poster card.
 * @param data The [MovieDetails] object containing information about the movie.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ConstraintLayoutScope.DetailMovie(
    detailRef: ConstrainedLayoutReference,
    favoriteRef: ConstrainedLayoutReference,
    posterRef: ConstrainedLayoutReference,
    data: MovieDetails
) {
    FlowColumn(
        modifier = Modifier
            .padding(horizontal = DmcTheme.spacing.small)
            .fillMaxWidth()
            .constrainAs(detailRef) {
                top.linkTo(favoriteRef.bottom)
                start.linkTo(posterRef.end)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
    ) {
        TitleLargeText(text = data.title)
        Row(modifier = Modifier.padding(top = DmcTheme.spacing.small)) {
            data.runtime?.let { time ->
                ElevatedAssistChip(
                    leadingIcon = {
                        Icon(
                            DmcIcons.Schedule,
                            contentDescription = null
                        )
                    },
                    onClick = {},
                    label = { Text(text = time) },
                    modifier = Modifier.padding(end = DmcTheme.spacing.small)
                )
            }
            data.releaseDate?.run {
                ElevatedAssistChip(
                    leadingIcon = {
                        Icon(
                            DmcIcons.CalendarMonth,
                            contentDescription = null
                        )
                    },
                    onClick = {},
                    label = { Text(text = this) },
                    modifier = Modifier
                        .padding(start = DmcTheme.spacing.small)
                )
            }
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            data.genres.forEach { genre ->
                SuggestionChip(
                    onClick = { /*TODO*/ },
                    label = { Text(genre.name) },
                    modifier = Modifier.padding(end = DmcTheme.spacing.small)
                )
            }
        }
    }
}

/**
 * Composable function for displaying the movie poster card within a constrained layout.
 *
 * @param posterRef The [ConstrainedLayoutReference] for the poster card.
 * @param favorite The [ConstrainedLayoutReference] for the favorite icon.
 * @param backdropHeight The height of the backdrop image.
 * @param posterPath The path to the movie poster image.
 */
@Composable
private fun ConstraintLayoutScope.PosterCard(
    posterRef: ConstrainedLayoutReference,
    favorite: ConstrainedLayoutReference,
    backdropHeight: Dp,
    posterPath: String
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = DmcTheme.spacing.extraSmall),
        modifier =
        Modifier
            .height(backdropHeight.div(2f))
            .width(backdropHeight.div(3f))
            .padding(start = DmcTheme.spacing.small)
            .constrainAs(posterRef) {
                top.linkTo(favorite.top)
                start.linkTo(parent.start)
            }
    ) {
        AsyncImageCoil(
            model = posterPath
        )
    }
}

/**
 * Composable function for displaying the favorite icon within a constrained layout.
 *
 * @param favorite The [ConstrainedLayoutReference] for the favorite icon.
 * @param backdropRef The [ConstrainedLayoutReference] for the backdrop image.
 * @param onClickFavorite Callback for handling the click event on the favorite icon.
 */
@Composable
private fun ConstraintLayoutScope.FavoriteIcon(
    favorite: ConstrainedLayoutReference,
    backdropRef: ConstrainedLayoutReference,
    onClickFavorite: () -> Unit,
) {
    val clickFavorite = remember {
        mutableStateOf(false)
    }

    FilledIconButton(
        modifier = Modifier
            .padding(end = DmcTheme.spacing.medium)
            .constrainAs(favorite) {
                top.linkTo(backdropRef.bottom)
                bottom.linkTo(backdropRef.bottom)
                end.linkTo(backdropRef.end)
            },
        onClick = onClickFavorite
    ) {
        Icon(
            imageVector = if (!clickFavorite.value) DmcIcons.FavoriteBorderFilled else DmcIcons.FavoriteFilled,
            contentDescription = null
        )
    }
}

/**
 * Composable function for displaying the top component, including the backdrop image and back button.
 *
 * @param backdropRef The [ConstrainedLayoutReference] for the backdrop image.
 * @param backdropHeight The height of the backdrop image.
 * @param data The [MovieDetails] object containing information about the movie.
 * @param onClickBackButton Callback for handling the click event on the back button.
 */
@Composable
private fun ConstraintLayoutScope.TopComponent(
    backdropRef: ConstrainedLayoutReference,
    backdropHeight: Dp,
    data: MovieDetails,
    onClickBackButton: () -> Unit
) {
    Box(
        modifier = Modifier
            .constrainAs(backdropRef) {}
    ) {
        AsyncImageCoil(
            model = data.backdropPath,
            modifier = Modifier
                .height(backdropHeight)
                .fillMaxWidth()
        )
        FilledIconButton(
            modifier = Modifier
                .padding(top = DmcTheme.spacing.large, start = DmcTheme.spacing.small)
                .align(Alignment.TopStart),
            onClick = {
                onClickBackButton()
            },
        ) {
            Icon(
                DmcIcons.ArrowBack,
                contentDescription = "voltar"
            )
        }
    }
}