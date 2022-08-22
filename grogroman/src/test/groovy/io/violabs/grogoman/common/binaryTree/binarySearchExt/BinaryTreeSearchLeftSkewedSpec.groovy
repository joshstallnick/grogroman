package io.violabs.grogoman.common.binaryTree.binarySearchExt

import io.violabs.grogroman.common.binaryTree.BinarySearchExt
import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import spock.lang.Specification

class BinaryTreeSearchLeftSkewedSpec extends Specification {
  def 'isLeftSkewedBinaryTree is correct'() {
    given:
    //       18
    //     15
    //   14
    //  8
    def numbers = [18, 15, 14, 8]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    BinarySearchExt.INSTANCE.isLeftSkewedBinaryTree(binaryTree)
  }

  def 'isLeftSkewedBinaryTree fails if complete binary tree'() {
    given:
    //       18
    //   15      30
    // 14  16  29
    def numbers = [18, 15, 30, 29, 14, 16]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    !BinarySearchExt.INSTANCE.isLeftSkewedBinaryTree(binaryTree)
  }
}
