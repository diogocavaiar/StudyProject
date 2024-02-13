package br.com.dmcconsulting.common.extension

private const val MASK_HOUR = "%dh:%02dm"

/**
 * Converts an integer representing minutes to a formatted relative time string.
 *
 * This extension function takes an integer value representing minutes and formats it into a string
 * representing relative time in the format "%dh:%02dm", where 'h' represents hours and 'm' represents minutes.
 * For example, 135 minutes would be formatted as "2h:15m".
 *
 * @return A formatted relative time string.
 *
 * Usage Example:
 * ```
 * val totalMinutes: Int = 135
 * val relativeTimeString = totalMinutes.minuteToRelativeTime()
 * // The value of relativeTimeString is "2h:15m"
 * ```
 */
fun Int.minuteToRelativeTime(): String = MASK_HOUR.format(this / 60, this % 60)