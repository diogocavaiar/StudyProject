package br.com.dmcconsulting.designsystem.components

import HeadlineSmallText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.dmcconsulting.designsystem.theme.DmcTheme

/**
 * Composable function to display a section with a list of items in a row.
 *
 * @param section The title of the section.
 * @param items The list of items to be displayed in the row.
 * @param content The composable function that defines the content of each item in the row.
 * @param modifier An optional [Modifier] to apply to the entire section row.
 * @param T The type of items in the list.
 */
@Composable
inline fun <reified T> SectionRowPeople(
    section: String,
    items: List<T>,
    crossinline content: @Composable (T) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        HeadlineSmallText(
            text = section,
            modifier = Modifier.padding(top = DmcTheme.spacing.medium)
        )
        LazyRow(
            modifier = Modifier.padding(top = DmcTheme.spacing.medium),
            state = rememberLazyListState()
        ) {
            items(items = items, key = { it.hashCode() }) { item ->
                content(item)
            }
        }
    }
}
