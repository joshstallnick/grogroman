package io.violabs.grogroman.hackerrank.superKthLIS

data class NodePath(val n: Int, val child: NodePath? = null) {
  private fun flatten(): MutableList<Int> {
    if (child == null) return mutableListOf(n)

    return child.flatten().also { it.add(n) }
  }

  companion object {
    fun flatten(nodePath: NodePath): List<Int> = nodePath.flatten().reversed()
  }
}