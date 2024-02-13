package br.com.dmcconsulting.networkimpl.di

import br.com.dmcconsulting.networkimpl.BuildConfig
import br.com.dmcconsulting.networkimpl.configuration.AccessTokenProvider
import br.com.dmcconsulting.networkimpl.configuration.BaseUrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideAccessToken() = object : AccessTokenProvider {
        override val accessToken: String = BuildConfig.ACCESS_TOKEN
    }

    @Provides
    fun provideBaseUrl() = object : BaseUrlProvider {
        override val baseUrl: String = BuildConfig.BASE_URL
    }

}