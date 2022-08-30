package io.violabs.grogroman.common

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MatrixTest {

  @Test
  fun arrayMatrixLeftDiagonal() {
    //given
    val matrix: ArrayMatrix<Int> = arrayOf(
      arrayOf(1, 4, 5),
      arrayOf(6, 2, 7),
      arrayOf(8, 9, 3)
    )

    val expected = listOf(1, 2, 3)

    //when
    val actual: List<Int> = matrix.leftDiagonal()

    //then
    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun arrayMatrixRightDiagonal() {
    //given
    val matrix: ArrayMatrix<Int> = arrayOf(
      arrayOf(5, 4, 1),
      arrayOf(6, 2, 7),
      arrayOf(3, 9, 8)
    )

    val expected = listOf(1, 2, 3)

    //when
    val actual: List<Int> = matrix.rightDiagonal()

    //then
    Assertions.assertEquals(expected, actual)
  }
}