package io.violabs.grogroman.hackerrank

typealias IndexPair = Pair<Int, Int>

fun IntRange.pair(n: Int): Sequence<IndexPair> = this.asSequence().map { Pair(n, it) }

fun IntRange.selfCartesianProduct(): Sequence<IndexPair> = this.asSequence().flatMap(this::pair)

fun IndexPair.firstLessThanSecond(): Boolean = this.first < this.second

object DivisibleSumPairs {
    fun run(n: Int, k: Int, ar: Array<Int>): Int {
        val validIndexes: Sequence<IndexPair> =
            (0 until n)
                .selfCartesianProduct()
                .filter(IndexPair::firstLessThanSecond)

        return validIndexes
            .map { (a, b) -> ar[a] + ar[b] }
            .filter { it % k == 0 }
            .count()
    }
}