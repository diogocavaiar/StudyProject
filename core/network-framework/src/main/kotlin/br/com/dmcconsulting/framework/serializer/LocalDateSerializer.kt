package br.com.dmcconsulting.framework.serializer

import java.text.ParseException
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toLocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Custom serializer for serializing and deserializing [LocalDate] objects.
 *
 * This class implements the [KSerializer] interface for handling serialization and deserialization
 * of [LocalDate] objects. It converts [LocalDate] objects to and from strings.
 */
class LocalDateSerializer : KSerializer<LocalDate?> {

    /**
     * The descriptor for the [LocalDateSerializer].
     *
     * This specifies the serial name and kind for the serializer.
     */
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
        serialName = "LocalDate",
        kind = PrimitiveKind.STRING
    )

    /**
     * Serializes a [LocalDate] object into a string representation.
     *
     * @param encoder The encoder to use for serialization.
     * @param value The [LocalDate] value to be serialized.
     */
    override fun serialize(encoder: Encoder, value: LocalDate?) =
        encoder.encodeString(value.toString())

    /**
     * Deserializes a string into a [LocalDate] object.
     *
     * @param decoder The decoder to use for deserialization.
     * @return The deserialized [LocalDate] object or null if the string is empty.
     * @throws SerializationException if deserialization fails due to a [ParseException].
     */
    override fun deserialize(decoder: Decoder): LocalDate? = try {
        val string = decoder.decodeString()
        if (string.isNotEmpty()) {
            string.toLocalDate()
        } else {
            null
        }
    } catch (exception: ParseException) {
        throw SerializationException(exception)
    }
}

