package io.violabs.grogroman.hackerrank

object NumberLineJumps {

  fun run(x1: Int, v1: Int, x2: Int, v2: Int): String {
    if (x1 < x2 && v1 > v2) return calculateRun(x1, v1, x2, v2)

    return "NO"
  }

  private fun calculateRun(x1: Int, v1: Int, x2: Int, v2: Int): String {
    var leftPosition: Int = x1
    var rightPosition: Int = x2

    while (leftPosition < rightPosition) {
      leftPosition += v1
      rightPosition += v2
    }

    return if (leftPosition == rightPosition) "YES" else "NO"
  }
}