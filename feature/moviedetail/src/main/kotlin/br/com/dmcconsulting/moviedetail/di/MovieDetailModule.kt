package br.com.dmcconsulting.moviedetail.di

import br.com.dmcconsulting.moviedetail.data.network.MovieDetailNetworkDataSource
import br.com.dmcconsulting.moviedetail.data.network.MovieDetailNetworkDataSourceImpl
import br.com.dmcconsulting.moviedetail.data.network.api.DetailApi
import br.com.dmcconsulting.moviedetail.data.repository.MovieDetailRepositoryImpl
import br.com.dmcconsulting.moviedetail.domain.repository.MovieDetailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieDetailModule {

    @Binds
    abstract fun providesMovieDetailNetworkDataSource(movieDetailNetworkDataSourceImpl: MovieDetailNetworkDataSourceImpl): MovieDetailNetworkDataSource

    @Binds
    abstract fun providesMovieDetailRepository(movieDetailRepositoryImpl: MovieDetailRepositoryImpl): MovieDetailRepository

    companion object {
        @Singleton
        @Provides
        fun provideDetailMovieService(api: DetailApi) = api.detailMovieService
    }
}