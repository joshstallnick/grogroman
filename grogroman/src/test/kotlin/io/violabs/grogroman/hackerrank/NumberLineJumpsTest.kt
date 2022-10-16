package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class NumberLineJumpsTest : TestHarness() {

  @Test
  fun runTest1() = test {
    expect { "NO" }

    whenever { NumberLineJumps.run(0, 2, 5, 3) }
  }

  @Test
  fun runTest2() = test {
    expect { "NO" }

    whenever { NumberLineJumps.run(21, 6, 47, 3) }
  }
}