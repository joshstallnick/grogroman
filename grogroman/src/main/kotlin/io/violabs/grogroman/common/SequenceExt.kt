package io.violabs.grogroman.common

fun <T> Sequence<T>.println(message: String = ""): Sequence<T> = this.onEach { kotlin.io.println("$message$it") }