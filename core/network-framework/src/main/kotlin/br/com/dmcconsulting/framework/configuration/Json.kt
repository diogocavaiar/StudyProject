package br.com.dmcconsulting.framework.configuration

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

/**
 * Default [Json] configuration for serialization with experimental features enabled.
 * It ignores unknown keys during deserialization and does not use explicit nulls.
 */
@OptIn(ExperimentalSerializationApi::class)
internal val defaultJson = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
}

