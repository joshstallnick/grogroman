package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class StaircaseTest {

  @Test
  fun test() {
    //given
    val expected: List<String> = listOf(
      "     #",
      "    ##",
      "   ###",
      "  ####",
      " #####",
      "######",
    )

    //when
    val actual: List<String> = Staircase.run(6)

    //then
    expected.testEquals(actual)
  }
}