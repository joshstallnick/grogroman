package io.violabs.grogoman.common.binaryTree.binarySearchExt

import io.violabs.grogroman.common.binaryTree.BinarySearchExt
import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import spock.lang.Specification

class BinaryTreeSearchDegenerateSpec extends Specification {
  def 'isPerfectBinaryTree is correct'() {
    given:
    //       18
    //     15
    //      16
    //        17
    def level1BothFull = [18, 15, 16, 17]

    def binaryTree = new IntBinaryTree(level1BothFull)

    expect:
    BinarySearchExt.INSTANCE.isDegenerateBinaryTree(binaryTree)
  }

  def 'isPerfectBinaryTree fails if complete binary tree'() {
    given:
    //       18
    //   15      30
    // 14  16  29
    def level1BothFull = [18, 15, 30, 29, 14, 16]

    def binaryTree = new IntBinaryTree(level1BothFull)

    expect:
    !BinarySearchExt.INSTANCE.isDegenerateBinaryTree(binaryTree)
  }
}
