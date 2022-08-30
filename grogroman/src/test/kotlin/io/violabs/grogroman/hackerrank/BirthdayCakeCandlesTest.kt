package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class BirthdayCakeCandlesTest {

  @Test
  fun test() {
    //given
    val candles = arrayOf(3, 2, 1, 3)

    val expected = 2

    //when
    val actual: Int = BirthdayCakeCandles.run(candles)

    //then
    expected.testEquals(actual)
  }
}