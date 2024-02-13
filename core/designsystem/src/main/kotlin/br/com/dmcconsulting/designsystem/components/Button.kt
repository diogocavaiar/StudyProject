package br.com.dmcconsulting.designsystem.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import br.com.dmcconsulting.designsystem.icon.DmcIcons
import br.com.dmcconsulting.designsystem.theme.DmcTheme

/**
 * Composable function representing an outlined button with specific customization options for the Digital Movie Collection (DMC) app.
 *
 * @param textResourceId The resource ID of the text to be displayed on the button.
 * @param onClick Lambda function to be executed when the button is clicked.
 * @param modifier Optional modifier for the button layout.
 * @param shape The shape of the button.
 * @param containerColor The background color of the button container.
 * @param contentColor The color of the button content.
 * @param borderColor The color of the button border.
 * @param textStyle The style to be applied to the button text.
 */
@Composable
fun DmcOutlinedButton(
    @StringRes textResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = DmcTheme.shapes.medium,
    containerColor: Color = Color.Transparent,
    contentColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = contentColor,
    textStyle: TextStyle = DmcTheme.typography.labelMedium
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(borderColor))
    ) {
        Icon(imageVector = DmcIcons.AutoRenewFilled, contentDescription = "")
        Spacer(modifier = Modifier.padding(start = DmcTheme.spacing.small))
        Text(text = stringResource(id = textResourceId), style = textStyle)
    }
}
