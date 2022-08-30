package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class TimeConversionTest {

  @Test
  fun test() {
    //given
    val time = "07:05:45PM"

    val expected = "19:05:45"

    //when
    val actual: String = TimeConversion.run(time)

    //then
    expected.testEquals(actual)
  }
}