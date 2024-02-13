package br.com.dmcconsulting.common.viewmodel

import androidx.lifecycle.ViewModel
import br.com.dmcconsulting.common.mvi.Intent
import br.com.dmcconsulting.common.mvi.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * Abstract base class for ViewModel with state management.
 *
 * @param STATE The type of state managed by the ViewModel.
 * @param INTENT The type of intent that can trigger state changes.
 * @param initialState The initial state of the ViewModel.
 */
abstract class ViewModelState<STATE : State, INTENT : Intent>(initialState: STATE) :
    ViewModel() {

    /**
     * MutableStateFlow representing the current state of the ViewModel.
     */
    private val _state: MutableStateFlow<STATE> = MutableStateFlow(initialState)

    /**
     * Immutable StateFlow providing external access to the ViewModel state.
     */
    val state: StateFlow<STATE> get() = _state

    /**
     * Abstract function to handle incoming intents and trigger state changes.
     *
     * @param intent The intent received by the ViewModel.
     */
    abstract fun intent(intent: INTENT)

    /**
     * Protected function to set the new state based on a transformation block.
     *
     * @param block The transformation block to apply to the current state.
     */
    protected fun setState(block: STATE.() -> STATE) {
        _state.update(block)
    }
}
