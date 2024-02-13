package br.com.dmcconsulting.analytics.di

import br.com.dmcconsulting.analytics.AnalyticsHelper
import br.com.dmcconsulting.analytics.FirebaseAnalyticsHelper
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsModule {

    @Provides
    @Singleton
    fun provideFirebaseAnalytics(): FirebaseAnalytics = Firebase.analytics

    @Singleton
    @Provides
    fun bindsAnalyticsHelper(analytics: FirebaseAnalytics): AnalyticsHelper = FirebaseAnalyticsHelper(analytics)
}
