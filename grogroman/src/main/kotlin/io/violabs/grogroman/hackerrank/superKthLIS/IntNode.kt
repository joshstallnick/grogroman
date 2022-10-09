package io.violabs.grogroman.hackerrank.superKthLIS

typealias IntTree = IntNode

data class IntNode(
  val n: Int,
  var maxDepth: Int = 0,
  var level: Int = 1,
  var children: MutableMap<Int, IntNode> = mutableMapOf()
) {

  private fun addChild(other: Int): Int {
    if (other <= this.n) return this.level

    val existingChild: IntNode? = children[other]

    if (existingChild != null) return existingChild.level

    children.values.forEach { it.addChild(other) }

    val level = this.level + 1

    children[other] = IntNode(other, level = level)

    return level
  }

  fun nodePaths(maxDepth: Int? = null): Sequence<NodePath> {
    val depth: Int = maxDepth ?: this.maxDepth

    if (depth == level) return sequenceOf(NodePath(n))

    return children
      .values
      .asSequence()
      .flatMap(this::mapChildrenToNodePaths)
  }

  private fun mapChildrenToNodePaths(intNode: IntNode): Sequence<NodePath> =
    intNode
      .nodePaths(maxDepth)
      .map { NodePath(n, it) }

  fun hasChildren(): Boolean = children.isNotEmpty()

  fun hasDepth(depth: Int): Boolean = level == depth

  companion object {
    fun addChild(root: IntNode, child: Int) {
      val level: Int = root.addChild(child)

      if (root.maxDepth >= level) return

      root.maxDepth = level
    }
  }
}

