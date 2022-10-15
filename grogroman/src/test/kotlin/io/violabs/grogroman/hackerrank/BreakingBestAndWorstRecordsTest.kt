package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class BreakingBestAndWorstRecordsTest : TestHarness() {

    @Test
    fun runTest1() = test {
        given { listOf(2, 4) }

        whenever {
            val inputs = arrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1)

            BreakingBestAndWorstRecords.run(inputs)
        }
    }

    @Test
    fun runTest2() = test {
        given { listOf(4, 0) }

        whenever {
            val inputs = arrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)

            BreakingBestAndWorstRecords.run(inputs)
        }
    }
}