package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class GradingStudentsTest : TestHarness() {

  @Test
  fun testRun() = testArray {
    given { arrayOf(75, 67, 40, 33) }

    whenever {
      val input = arrayOf(73, 67, 38, 33)

      GradingStudents.run(input)
    }
  }
}