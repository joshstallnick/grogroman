package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class BetweenTwoSetsTest : TestHarness() {

  @Test
  fun runTest1() = test {
    expect { 3 }

    whenever {
      BetweenTwoSets.run(
        arrayOf(2, 4),
        arrayOf(16, 32, 96)
      )
    }
  }
}