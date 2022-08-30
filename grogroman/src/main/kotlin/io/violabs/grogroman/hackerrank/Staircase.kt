package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.common.times

object Staircase {

  fun run(number: Int): List<String> =
    (1 .. number)
      .asSequence()
      .map { buildStepContent(number, it) }
      .map { it.joinToString("") }
      .toList()

  private fun buildStepContent(number: Int, n: Int): List<String> {
    val gapAmount = number - n
    val gaps: List<String> = GAP.times(gapAmount)

    val stepAmount = number - gapAmount
    val steps: List<String> = STEP.times(stepAmount)

    return gaps + steps
  }

  private const val STEP = "#"
  private const val GAP = " "
}