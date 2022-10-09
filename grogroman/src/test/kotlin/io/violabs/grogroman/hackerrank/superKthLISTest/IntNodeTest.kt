package io.violabs.grogroman.hackerrank.superKthLISTest

import io.violabs.grogroman.hackerrank.superKthLIS.IntNode
import io.violabs.grogroman.hackerrank.superKthLIS.NodePath
import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class IntNodeTest {
  @Test
  fun nodePaths() {
    //given
    val tree = IntNode(
      1,
      maxDepth = 3,
      children = mutableMapOf(
        3 to IntNode(
          3,
          level = 2,
          children = mutableMapOf(
            5 to IntNode(
              5,
              level = 3
            )
          )
        ),
        2 to IntNode(
          2,
          level = 2,
          children = mutableMapOf(
            5 to IntNode(
              5,
              level = 3
            )
          )
        ),
        5 to IntNode(
          5,
          level = 2
        )
      )
    )

    val expected: List<NodePath> = listOf(
      NodePath(1, child = NodePath(3, child = NodePath(5))),
      NodePath(1, child = NodePath(2, child = NodePath(5)))
    )

    //when
    val actual: List<NodePath> = tree.nodePaths().toList()

    //then
    expected.testEquals(actual)
  }

  @Test
  fun addChild() {
    //given
    val root = IntNode(1)

    val expected = IntNode(
      1,
      maxDepth = 2,
      children = mutableMapOf(
        2 to IntNode(2, level = 2)
      )
    )

    //when
    IntNode.addChild(root, 2)

    //then
    expected.testEquals(root)
  }
}