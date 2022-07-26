package io.violabs.grogroman

object ClimbingTheLeaderboard {

  fun run(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    val leaderBoard = LeaderBoard(ranked)

    return player
      .asSequence()
      .map { checkScore(leaderBoard, it) }
      .map { 1 + it }
      .toList()
      .toTypedArray()
  }


  private fun checkScore(leaderBoard: LeaderBoard, score: Int): Int {
    return checkHighScore(leaderBoard, score)
      ?: checkLowScore(leaderBoard, score)
      ?: addMiddleScore(leaderBoard, score)
      ?: -1
  }

  private fun checkHighScore(leaderBoard: LeaderBoard, score: Int): Int? {
    val currentHighScore: Int = leaderBoard.highScore

    if (currentHighScore > score) return null

    return 0
  }

  private fun checkLowScore(leaderBoard: LeaderBoard, score: Int): Int? {
    val currentLowScore: Int = leaderBoard.lowScore

    if (currentLowScore < score) return null

    val scoreRanges: List<IntProgression> = leaderBoard.scoreRanges

    if (currentLowScore == score) return scoreRanges.lastIndex + 1

    return scoreRanges.lastIndex + 2
  }

  private fun addMiddleScore(leaderBoard: LeaderBoard, score: Int): Int? {
    val scoreRanges: List<IntProgression> = leaderBoard.scoreRanges

    val index: Int = scoreRanges.indexOfFirst { score in it }

    return index + 1
  }

  class LeaderBoard(rankedArray: Array<Int>) {

    val scoreRanges: List<IntProgression> = buildIntRanges(rankedArray)

    var highScore: Int = rankedArray[0]
    var lowScore: Int = rankedArray.getOrElse(rankedArray.lastIndex) { 0 }
  }

  private fun buildIntRanges(rankedArray: Array<Int>): List<IntProgression> =
    rankedArray
      .asSequence()
      .distinct()
      .windowed(2)
      .map {
        val start: Int = it.firstOrNull() ?: 0
        val end: Int = it.lastOrNull() ?: 0

        (start downTo end)
      }
      .toList()
}