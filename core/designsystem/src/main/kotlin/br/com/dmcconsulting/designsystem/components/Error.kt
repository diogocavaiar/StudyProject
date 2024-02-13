package br.com.dmcconsulting.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import br.com.dmcconsulting.designsystem.R
import br.com.dmcconsulting.designsystem.theme.DmcTheme
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

/**
 * Composable function representing an error view with optional retry functionality.
 *
 * @param errorText The text to be displayed indicating the error.
 * @param modifier Optional modifier for the layout.
 * @param onRetry Lambda function to be executed when the retry button is clicked. If null, the retry button won't be displayed.
 */
@Composable
fun ErrorView(
    errorText: String,
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null
) {
    // Remember Lottie composition and animate its state
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_error))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    // Layout for error view
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(DmcTheme.spacing.medium)
    ) {
        // Lottie animation
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .testTag("errorLottieView")
                .size(DmcTheme.spacing.space200)
        )
        // Error text
        Text(
            text = errorText,
            textAlign = TextAlign.Center,
            modifier = Modifier.testTag("errorText")
        )
        // Retry button if onRetry is not null
        onRetry?.let {
            DmcOutlinedButton(
                textResourceId = R.string.retry,
                modifier = Modifier
                    .padding(DmcTheme.spacing.small),
                onClick = onRetry
            )
        }
    }
}

