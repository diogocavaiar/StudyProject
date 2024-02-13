package br.com.dmcconsulting.movie.di

import br.com.dmcconsulting.movie.data.network.MovieNetworkDataSource
import br.com.dmcconsulting.movie.data.network.MovieNetworkDataSourceImpl
import br.com.dmcconsulting.movie.data.network.api.MovieApi
import br.com.dmcconsulting.movie.data.repository.MovieRepositoryImpl
import br.com.dmcconsulting.movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieModule {

    @Binds
    abstract fun providesMovieDetailNetworkDataSource(movieNetworkDataSourceImpl: MovieNetworkDataSourceImpl): MovieNetworkDataSource

    @Binds
    abstract fun providesMovieDetailRepository(movieRepository: MovieRepositoryImpl): MovieRepository

    companion object {
        @Singleton
        @Provides
        fun provideMovieService(api: MovieApi) = api.movieService
    }
}