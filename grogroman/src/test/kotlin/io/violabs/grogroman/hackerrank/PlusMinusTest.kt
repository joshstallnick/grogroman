package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class PlusMinusTest {

  @Test
  fun test() {
    // [-4, 3, -9, 0, 4, 1]
    //given
    val numbers = arrayOf(-4, 3, -9, 0, 4, 1)

    val expected: List<Double> = listOf(
      0.500000,
      0.333333,
      0.166667
    )

    //when
    val actual: Array<Double> = PlusMinus.run(numbers)

    //then
    expected.testEquals(actual)
  }
}