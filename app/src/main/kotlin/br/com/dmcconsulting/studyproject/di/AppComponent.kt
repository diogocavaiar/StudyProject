package br.com.dmcconsulting.studyproject.di

import br.com.dmcconsulting.common.di.DispatcherModule
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component responsible for providing dependencies throughout the application.
 * This component is annotated with @Singleton to ensure that only one instance of each dependency
 * is created and reused across the entire application.
 *
 * @property modules List of modules to be included in the component. Currently, only [DispatcherModule] is included.
 */
@Singleton
@Component(
    modules = [
        DispatcherModule::class,
    ]
)
interface AppComponent
