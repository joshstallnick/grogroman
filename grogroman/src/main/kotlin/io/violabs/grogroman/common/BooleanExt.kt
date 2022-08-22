package io.violabs.grogroman.common

fun Boolean?.t(): Boolean = this ?: false
fun Boolean?.n(): Boolean = this?.not() ?: true