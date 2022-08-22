package io.violabs.grogoman.common.binaryTree.binarySearchExt

import io.violabs.grogroman.common.binaryTree.BinarySearchExt
import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import spock.lang.Specification

class BinaryTreeSearchBalancedSpec extends Specification {

  def 'isBalancedBinaryTree is correct'() {
    given:
    //       18
    //   15      30
    // 14  16
    def numbers = [18, 15, 30, 14, 16]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    BinarySearchExt.INSTANCE.isBalancedBinaryTree(binaryTree)
  }

  def 'isBalancedBinaryTree fails if complete binary tree'() {
    given:
    //         18
    //     15      30
    //   14  16
    // 9
    def numbers = [18, 15, 30, 14, 16, 9]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    !BinarySearchExt.INSTANCE.isBalancedBinaryTree(binaryTree)
  }
}
