package br.com.dmcconsulting.networkimpl.common

import br.com.dmcconsulting.common.result.Result
import br.com.dmcconsulting.framework.result.ResponseAsync
import br.com.dmcconsulting.framework.result.isFailure
import br.com.dmcconsulting.framework.result.isSuccess
import br.com.dmcconsulting.networkimpl.util.MESSAGE_UNHANDLED_STATE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * A generic function for making a network request and handling the results in a Flow.
 *
 * @param ResultType The type of data to be queried and emitted in the Flow.
 * @param RequestType The type of data to be fetched from the network.
 * @param fetch A suspend function to fetch data from the network.
 * @return A Flow emitting the loading state, followed by the network request result.
 */
inline fun <ResultType, RequestType> makeRequest(
    crossinline fetch: suspend () -> ResponseAsync<RequestType>,
    crossinline mapWhenSuccess: (RequestType) -> ResultType
): Flow<Result<ResultType>> = flow {
    emit(Result.Loading)
    val response = fetch()

    val flow = when {
        response.isSuccess() -> {
            Result.success(mapWhenSuccess(response.value))
        }

        response.isFailure() -> {
            val throwable = response.error
            Result.failure(throwable)
        }

        else -> error("$MESSAGE_UNHANDLED_STATE $response")
    }

    emit(flow)
}