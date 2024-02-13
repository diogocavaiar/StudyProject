package br.com.dmcconsulting.framework.result

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Checks if the [ResponseAsync] is in a loading state.
 *
 * @return `true` if the response is in a loading state, `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
fun <T> ResponseAsync<T>.isLoading(): Boolean {
    contract {
        returns(true) implies (this@isLoading is ResponseAsync.Loading<T>)
    }
    return this is ResponseAsync.Loading<T>
}

/**
 * Checks if the [ResponseAsync] represents a successful response.
 *
 * @return `true` if the response is successful, `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
fun <T> ResponseAsync<T>.isSuccess(): Boolean {
    contract {
        returns(true) implies (this@isSuccess is ResponseAsync.Success<T>)
    }
    return this is ResponseAsync.Success<T>
}

/**
 * Checks if the [ResponseAsync] represents a failure response.
 *
 * @return `true` if the response is a failure, `false` otherwise.
 */
@OptIn(ExperimentalContracts::class)
fun <T> ResponseAsync<T>.isFailure(): Boolean {
    contract {
        returns(true) implies (this@isFailure is ResponseAsync.Failure<T>)
    }
    return this is ResponseAsync.Failure<T>
}

