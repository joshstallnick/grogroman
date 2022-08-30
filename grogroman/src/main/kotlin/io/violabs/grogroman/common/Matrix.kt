package io.violabs.grogroman.common

typealias ArrayMatrix<T> = Array<Array<T>>

fun <T> ArrayMatrix<T>.leftDiagonal(): List<T> = sharedDiagonal(this.indices)
fun <T> ArrayMatrix<T>.rightDiagonal(): List<T> = sharedDiagonal(this.indices.reversed())

private fun <T> ArrayMatrix<T>.sharedDiagonal(columnIndices: IntProgression): List<T> =
  this
    .indices
    .zip(columnIndices)
    .map { (r, c) -> this[r][c] }
    .toList()

