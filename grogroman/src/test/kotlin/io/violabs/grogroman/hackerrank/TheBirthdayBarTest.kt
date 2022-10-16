package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class TheBirthdayBarTest : TestHarness() {

    @Test
    fun runTest1() = test {
        given { 2 }

        whenever {
            TheBirthdayBar.run(
                chocolateBar = arrayOf(1, 2, 1, 3, 2),
                day = 3,
                month = 2
            )
        }
    }

    @Test
    fun runTest2() = test {
        given { 0 }

        whenever {
            TheBirthdayBar.run(
                chocolateBar = arrayOf(1, 1, 1, 1, 1, 1),
                day = 3,
                month = 2
            )
        }
    }

    @Test
    fun runTest3() = test {
        given { 1 }

        whenever {
            TheBirthdayBar.run(
                chocolateBar = arrayOf(4),
                day = 4,
                month = 1
            )
        }
    }
}