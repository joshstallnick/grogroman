package io.violabs.grogroman.hackerrank

object MiniMaxSum {

  fun run(arr: Array<Int>): Array<Long> {
    val sortedArray: List<Long> = arr.sortedArray().map(Int::toLong)

    val first: Long = sortedArray.firstOrNull() ?: 0
    val last: Long = sortedArray.lastOrNull() ?: 0
    val sum: Long = sortedArray.sum()

    return arrayOf(sum - last, sum - first)
  }
}