package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.common.ArrayMatrix
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DiagonalDifferenceTest {

  @Test
  fun test1() = shared(
    matrix = arrayOf(
      arrayOf(11, 2, 4),
      arrayOf(4, 5, 6),
      arrayOf(10, 8, -12)
    ),
    expected = 15
  )

  //1 2 3
  //4 5 6
  //9 8 9
  @Test
  fun test2() = shared(
    matrix = arrayOf(
      arrayOf(1, 2, 3),
      arrayOf(4, 5, 6),
      arrayOf(9, 8, 9)
    ),
    expected = 2
  )

  private fun shared(matrix: ArrayMatrix<Int>, expected: Int) {
    val actual: Int = DiagonalDifference.run(matrix)

    Assertions.assertEquals(expected, actual)
  }
}