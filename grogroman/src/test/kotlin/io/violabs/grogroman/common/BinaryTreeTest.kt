package io.violabs.grogroman.common

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BinaryTreeTest {

  @Test
  fun test() {
    val items: MutableList<Int> = mutableListOf(8, 4, 9, 12, 5, 1, 10, 20)

    val binaryTree = BinaryTree(items, Int::compareTo)

    binaryTree.print()

    items.forEachIndexed { i, int ->
      Assertions.assertEquals(i, binaryTree.find(int))
    }
  }
}