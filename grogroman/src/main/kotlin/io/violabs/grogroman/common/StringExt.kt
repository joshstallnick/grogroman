package io.violabs.grogroman.common

fun String.times(n: Int): List<String> =
  (1 .. n)
    .asSequence()
    .map { this }
    .toList()