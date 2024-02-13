package br.com.dmcconsulting.framework.serializer

import kotlinx.datetime.LocalDate
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class LocalDateSerializerTest {

    private val serializer = LocalDateSerializer()

    private val json = Json

    @Test
    fun `serialize and deserialize LocalDate object`() {
        val date = LocalDate(2022, 2, 14)
        val serialized = json.encodeToString(serializer, date)
        val deserialized = json.decodeFromString(serializer, serialized)
        assertEquals(date, deserialized)
    }

    @Test
    fun `deserialize empty string to null`() {
        val deserialized = json.decodeFromString(serializer, "\"\"")
        assertEquals(null, deserialized)
    }
}