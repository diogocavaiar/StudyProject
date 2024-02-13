package br.com.dmcconsulting.networkimpl.util

/**
 * Extension function to convert a string representing an image path to a full image URL.
 *
 * @receiver The image path.
 * @return The full image URL.
 */
fun String?.asImageUrl(): String = this?.let {
    Constants.IMAGE_URL + this
} ?: ""


