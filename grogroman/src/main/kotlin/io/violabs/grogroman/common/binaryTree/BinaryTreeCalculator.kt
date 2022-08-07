package io.violabs.grogroman.common.binaryTree

import kotlin.math.*

fun Int.ifPositive(calculate: (Int) -> Double): Int = this.ifAbove(-1, calculate)
fun Int.ifAbove(amount: Int, calculate: (Int) -> Double): Int = if (this <= amount) 0 else calculate(this).toInt()

object BinaryTreeCalculator {
  fun maxNodesAtLevel(level: Int): Int = level.ifPositive { 2.0.pow(it) }

  // where root height starts at 1
  fun maxNodesAtHeight(height: Int): Int = height.ifPositive { 2.0.pow(height) - 1 }

  fun minLevelsForNumberOfNodes(amount: Int): Int = sharedMinForNumberOfNodes(amount)

  fun minHeightForNumberOfNodes(amount: Int): Int = sharedMinForNumberOfNodes(amount)

  private fun sharedMinForNumberOfNodes(amount: Int) = amount.ifPositive {
    val log2 = log2(it + 1.0)

    ceil(log2)
  }

  fun minLevelsForNumberOfLeaves(amount: Int): Int = amount.ifAbove(0) {
    val log2Leaf: Double = log2(amount.toDouble())

    val absolute: Double = abs(log2Leaf)

    absolute + 1
  }

  fun numberOfNodesWithTwoChildren(height: Int): Int = maxNodesAtHeight(height).ifAbove(0) { it - 1.0 }

  fun numberOfEdgesByNodeAmount(amount: Int): Int = amount.ifAbove(0) { it - 1.0 }

  fun numberOfNodesByEdgeAmount(amount: Int): Int = amount.ifAbove(0) { it + 1.0 }
}