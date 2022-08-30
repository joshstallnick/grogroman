package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.common.ArrayMatrix
import kotlin.math.abs

object DiagonalDifference {

  fun run(matrix: ArrayMatrix<Int>): Int {
    val difference: Int = matrix.leftDiagonalSum() - matrix.rightDiagonalSum()

    return abs(difference)
  }

  private fun ArrayMatrix<Int>.leftDiagonalSum(): Int = sharedDiagonalSum(this.indices)
  private fun ArrayMatrix<Int>.rightDiagonalSum(): Int = sharedDiagonalSum(this.indices.reversed())

  private fun ArrayMatrix<Int>.sharedDiagonalSum(columnIndices: IntProgression): Int =
    this
      .indices
      .zip(columnIndices)
      .asSequence()
      .map { (r, c) -> this[r][c] }
      .sum()
}