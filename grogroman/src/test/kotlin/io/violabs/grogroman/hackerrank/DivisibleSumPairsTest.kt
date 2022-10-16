package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test

class DivisibleSumPairsTest : TestHarness() {

    @Test
    fun runTest1() = test {
        expect { 5 }

        whenever {
            DivisibleSumPairs.run(
                6,
                3,
                arrayOf(1, 3, 2, 6, 1, 2)
            )
        }
    }

    @Test
    fun runTest2() = test {
        expect { 216 }

        whenever {
            DivisibleSumPairs.run(
                100,
                22,
                arrayOf(
                    43, 95, 51, 55, 40, 86, 65, 81, 51, 20, 47, 50, 65, 53, 23, 78, 75, 75, 47, 73,
                    25, 27, 14, 8, 26, 58, 95, 28, 3, 23, 48, 69, 26, 3, 73, 52, 34, 7, 40, 33, 56,
                    98, 71, 29, 70, 71, 28, 12, 18, 49, 19, 25, 2, 18, 15, 41, 51, 42, 46, 19, 98,
                    56, 54, 98, 72, 25, 16, 49, 34, 99, 48, 93, 64, 44, 50, 91, 44, 17, 63, 27, 3,
                    65, 75, 19, 68, 30, 43, 37, 72, 54, 82, 92, 37, 52, 72, 62, 3, 88, 82, 71
                )
            )
        }
    }

    @Test
    fun runTest3() = test {
        expect { 69 }

        whenever {
            DivisibleSumPairs.run(
                100,
                66,
                ("50 44 77 66 70 58 9 59 74 82 87 15 10 95 10 81 2 4 " +
                    "87 85 28 96 76 18 86 91 94 59 19 58 98 48 38 70" +
                    " 36 38 66 9 72 54 23 23 17 18 8 16 9 56 12 59 73 " +
                    "31 10 62 83 84 28 91 29 22 73 22 3 75 26 31 93 57 15" +
                    " 32 46 74 99 10 15 58 60 53 41 49 71 59 4 20 38 78" +
                    " 1 94 76 5 70 68 42 34 77 28 19 25 20 15")
                    .split(" ")
                    .map(String::toInt)
                    .toTypedArray()
            )
        }
    }

    @Test
    fun runTest4() = test {
        expect { 59 }

        whenever {
            DivisibleSumPairs.run(
                100,
                67,
                ("57 46 3 24 53 30 53 90 50 44 80 33 55 37 97 37 82 33 80 97 84 " +
                    "18 85 28 99 77 93 90 88 46 48 27 3 37 46 71 98 11 4 75 90 48 " +
                    "10 7 46 61 90 100 59 16 27 84 18 59 51 74 52 40 12 25 48 41 5 " +
                    "99 80 84 23 65 96 65 97 8 87 76 33 72 76 89 19 71 39 6 33 74 " +
                    "55 26 6 98 80 56 58 91 47 69 29 47 88 15 11 12")
                    .split(" ")
                    .map(String::toInt)
                    .toTypedArray()
            )
        }
    }
}