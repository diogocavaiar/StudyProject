package br.com.dmcconsulting.studyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import br.com.dmcconsulting.analytics.AnalyticsHelper
import br.com.dmcconsulting.analytics.LocalAnalyticsHelper
import br.com.dmcconsulting.designsystem.theme.StudyProjectTheme
import br.com.dmcconsulting.studyproject.features.home.presentation.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Entry point for the Android application. This activity is responsible for setting up the application environment
 * and initializing necessary components.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /** Injected instance of [AnalyticsHelper] for tracking analytics events. */
    @Inject
    lateinit var analyticsHelper: AnalyticsHelper

    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this
     * bundle contains the data it most recently supplied in [onSaveInstanceState].
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Set the content of the activity
        setContent {
            // Provide the AnalyticsHelper instance using CompositionLocal
            CompositionLocalProvider(LocalAnalyticsHelper provides analyticsHelper) {
                // Apply the theme and display the main screen
                StudyProjectTheme {
                    MainScreen()
                }
            }
        }
    }
}

