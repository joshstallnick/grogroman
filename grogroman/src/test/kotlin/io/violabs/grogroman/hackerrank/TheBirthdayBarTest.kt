package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class TheBirthdayBarTest : TestHarness() {

    @Test
    fun runTest1() = test {
        expect { 2 }

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
        expect { 0 }

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
        expect { 1 }

        whenever {
            TheBirthdayBar.run(
                chocolateBar = arrayOf(4),
                day = 4,
                month = 1
            )
        }
    }
}