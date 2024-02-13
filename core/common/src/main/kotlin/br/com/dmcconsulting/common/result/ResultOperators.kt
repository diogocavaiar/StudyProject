package br.com.dmcconsulting.common.result

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Checks if the result is in the loading state.
 *
 * @return `true` if the result is in the loading state; `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
fun <T> Result<T>.isLoading(): Boolean {
    contract {
        returns() implies (this@isLoading is Result.Loading)
    }
    return this is Result.Loading
}

/**
 * Checks if the result is in the success state.
 *
 * @return `true` if the result is in the success state; `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
fun <T> Result<T>.isSuccess(): Boolean {
    contract {
        returns() implies (this@isSuccess is Result.Success<T>)
    }
    return this is Result.Success<T>
}

/**
 * Checks if the result is in the failure state.
 *
 * @return `true` if the result is in the failure state; `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
fun <T> Result<T>.isFailure(): Boolean {
    contract {
        returns() implies (this@isFailure is Result.Failure<T>)
    }
    return this is Result.Failure<T>
}

