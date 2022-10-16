package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class MigratoryBirdsTest : TestHarness() {

    @Test
    fun runTest1() = test {
        expect { 3 }

        whenever { MigratoryBirds.run(arrayOf(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)) }
    }
}