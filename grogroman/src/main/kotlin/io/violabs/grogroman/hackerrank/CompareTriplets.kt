package io.violabs.grogroman.hackerrank

object CompareTriplets {

  fun compare(aliceScores: Array<Int>, bobScores: Array<Int>): Array<Int> {
    val finalScore = FinalScore()

    aliceScores
      .zip(bobScores)
      .asSequence()
      .map { (a, b) -> a.compareTo(b) }
      .forEach(finalScore::addNumber)

    return finalScore.toArray()
  }

  class FinalScore {
    private var alice: Int = 0
    private var bob: Int = 0

    fun addNumber(n: Int) {
      when(n) {
         1 -> alice++
        -1 -> bob++
         0 -> return
      }
    }

    fun toArray(): Array<Int> = arrayOf(alice, bob)
  }
}