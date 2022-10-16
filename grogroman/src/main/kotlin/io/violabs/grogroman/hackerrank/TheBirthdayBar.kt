package io.violabs.grogroman.hackerrank

object TheBirthdayBar {

    fun run(chocolateBar: Array<Int>, day: Int, month: Int): Int =
        chocolateBar
            .asSequence()
            .windowed(month)
            .map(List<Int>::sum)
            .filter(day::equals)
            .count()
}