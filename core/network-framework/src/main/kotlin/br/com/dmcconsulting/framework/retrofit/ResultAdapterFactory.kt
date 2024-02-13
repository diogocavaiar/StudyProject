package br.com.dmcconsulting.framework.retrofit

import br.com.dmcconsulting.framework.result.ResponseAsync
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit

/**
 * Factory for creating [CallAdapter] instances for handling Retrofit calls with [ResponseAsync] results.
 * This class is responsible for determining if the provided returnType is a Retrofit [Call] type
 * and if the inner type is a parameterized type of [ResponseAsync]. If so, it creates a [ResultCallAdapter]
 * for further handling.
 */
internal class ResultAdapterFactory : CallAdapter.Factory() {

    /**
     * Attempts to create a [CallAdapter] for Retrofit calls with [ResponseAsync] results.
     * @param returnType The return type of the Retrofit call.
     * @param annotations An array of annotations on the Retrofit call method.
     * @param retrofit The Retrofit instance.
     * @return A [CallAdapter] for Retrofit calls with [ResponseAsync] results, or null if the
     * conditions are not met.
     * @throws IllegalArgumentException if the return type is not a parameterized type.
     */
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) return null
        check(returnType is ParameterizedType) { "Return type must be a parameterized type." }

        val callInnerType = getParameterUpperBound(0, returnType)
        if (getRawType(callInnerType) != ResponseAsync::class.java) return null
        check(callInnerType is ParameterizedType) { "Response type must be a parameterized type." }

        val resultInnerType = getParameterUpperBound(0, callInnerType)
        return ResultCallAdapter<Any?>(resultInnerType)
    }
}

/**
 * [CallAdapter] for Retrofit calls with [ResponseAsync] results. It adapts the Retrofit call
 * to wrap the result in a [ResponseAsync] type.
 * @param T The type of data expected in the response.
 * @property type The type of the inner data in [ResponseAsync].
 */
private class ResultCallAdapter<T>(private val type: Type) :
    CallAdapter<T, Call<ResponseAsync<T>>> {

    /**
     * Gets the type of the inner data in [ResponseAsync].
     * @return The type of the inner data.
     */
    override fun responseType(): Type = type

    /**
     * Adapts the Retrofit call to wrap the result in a [ResponseAsync] type.
     * @param call The original Retrofit call.
     * @return A new Retrofit call that wraps the result in a [ResponseAsync] type.
     */
    override fun adapt(call: Call<T>): Call<ResponseAsync<T>> = ResultCall(call)
}

