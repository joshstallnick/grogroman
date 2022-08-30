package io.violabs.grogroman.common

import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class StringExtTest {

  @Test
  fun times() {
    //given
    val expected: List<String> = listOf("!", "!", "!")

    //when
    val actual: List<String> = "!".times(3)

    //then
    expected.testEquals(actual)
  }
}