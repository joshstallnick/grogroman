package io.violabs.grogoman.common.binaryTree.binarySearchExt

import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import io.violabs.grogroman.common.binaryTree.BinarySearchExt
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeSearchFullSpec extends Specification {

  //       18
  //   15      30
  // 14  16  29  31
  @Shared
  def level1BothFull = [18, 15, 30, 29, 14, 31, 16]

  //          18
  //      13      20
  //   9     14
  // 7  11
  @Shared
  def level2AllLeft = [18, 13, 20, 14, 9, 11, 7]

  //     18
  // 14      20
  //       19   21
  @Shared
  def level1AllRight = [18, 14, 20, 19, 21]

  @Unroll
  def 'isFullBinaryTree #scenario'() {
    given:
    IntBinaryTree binaryTree = new IntBinaryTree(numbers)

    expect:
    BinarySearchExt.INSTANCE.isFullBinaryTree(binaryTree)

    where:
    scenario            | numbers
    '1 level both full' | level1BothFull
    '2 level all left'  | level2AllLeft
    '1 level all right' | level1AllRight
  }

  def 'isFullBinaryTree not the case'() {
    given:
    def numbers = [19, 1, 13, 12]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    !BinarySearchExt.INSTANCE.isFullBinaryTree(binaryTree)
  }
}
