package io.violabs.grogroman.hackerrank.superKthLIS

class IntGrove(array: Array<Int>) {
  private val trees: MutableList<IntTree> = mutableListOf()

  init {
    for (n in array) {
      trees.forEach { IntNode.addChild(it, n) }
      trees.add(IntNode(n))
    }
  }

  private fun maxDepth(): Int = trees.maxOf(IntTree::maxDepth)

  fun longestNodes(): List<IntNode> = trees.filter { it.maxDepth == maxDepth() }
}