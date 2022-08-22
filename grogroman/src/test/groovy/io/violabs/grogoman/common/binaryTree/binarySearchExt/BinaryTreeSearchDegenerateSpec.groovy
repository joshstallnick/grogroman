package io.violabs.grogoman.common.binaryTree.binarySearchExt

import io.violabs.grogroman.common.binaryTree.BinarySearchExt
import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import spock.lang.Specification

class BinaryTreeSearchDegenerateSpec extends Specification {
  def 'isDegenerateBinaryTree is correct'() {
    given:
    //       18
    //     15
    //      16
    //        17
    def numbers = [18, 15, 16, 17]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    BinarySearchExt.INSTANCE.isDegenerateBinaryTree(binaryTree)
  }

  def 'isDegenerateBinaryTree fails if complete binary tree'() {
    given:
    //       18
    //   15      30
    // 14  16  29
    def numbers = [18, 15, 30, 29, 14, 16]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    !BinarySearchExt.INSTANCE.isDegenerateBinaryTree(binaryTree)
  }
}
