package br.com.dmcconsulting.designsystem.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


/**
 * Composable function representing an AlertDialog with both confirm and dismiss buttons.
 *
 * @param onDismissRequest Lambda function to be executed when the dismiss button is clicked.
 * @param onConfirmation Lambda function to be executed when the confirm button is clicked.
 * @param dialogTitle Title of the dialog.
 * @param dialogText Text content of the dialog.
 * @param icon Vector image to be displayed in the dialog.
 * @param contentDescriptionIcon Content description for the dialog icon.
 */
@Composable
fun AlertDialogWithConfirmAndDismissButton(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
    contentDescriptionIcon: String
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = contentDescriptionIcon)
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
