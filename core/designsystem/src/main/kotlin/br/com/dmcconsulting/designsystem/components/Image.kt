package br.com.dmcconsulting.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import br.com.dmcconsulting.designsystem.R
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.SubcomposeAsyncImageScope

/**
 * Composable function representing an asynchronous image loading component using Coil library.
 *
 * @param model The image resource to load. This can be a URL, URI, or drawable resource.
 * @param contentDescription Optional content description for the image.
 * @param modifier Optional modifier for the layout.
 * @param contentScale The scale at which the image content should be drawn within this layout.
 */
@Composable
fun AsyncImageCoil(
    model: Any?,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = model,
        contentDescription = contentDescription,
        contentScale = contentScale
    ) { SubComposeAsyncImageHandler() }
}

/**
 * Subcompose function to handle the loading state of the asynchronous image.
 */
@Composable
private fun SubcomposeAsyncImageScope.SubComposeAsyncImageHandler() {
    when (painter.state) {
        is AsyncImagePainter.State.Loading -> ShimmerImage()
        is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
        AsyncImagePainter.State.Empty, is AsyncImagePainter.State.Error -> NoImageAvailable()
    }
}

/**
 * Composable function displaying an error image when loading fails.
 */
@Composable
private fun NoImageAvailable() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.error)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_load_error),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }
    }
}

/**
 * Composable function displaying a shimmer effect when the image is loading.
 */
@Composable
private fun ShimmerImage(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        FieldLinearShimmer(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

