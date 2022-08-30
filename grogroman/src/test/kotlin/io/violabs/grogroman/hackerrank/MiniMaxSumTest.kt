package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class MiniMaxSumTest {

  @Test
  fun test() {
    //given
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)

    val expected: List<Long> = listOf(10, 14)

    //when
    val actual: Array<Long> = MiniMaxSum.run(numbers)

    //then
    expected.testEquals(actual)
  }
}