package br.com.dmcconsulting.analytics

/**
 * Limits the length of the [String] to the specified [maxLength].
 *
 * If the original string is longer than the specified [maxLength], it truncates the string to the maximum length.
 *
 * @param maxLength The maximum length to limit the string to.
 * @return A new [String] containing at most [maxLength] characters.
 *
 * @see take
 */
internal fun String.limitLength(maxLength: Int): String = take(maxLength)