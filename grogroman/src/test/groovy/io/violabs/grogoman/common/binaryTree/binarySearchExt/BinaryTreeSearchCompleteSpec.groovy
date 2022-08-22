package io.violabs.grogoman.common.binaryTree.binarySearchExt


import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import io.violabs.grogroman.common.binaryTree.BinarySearchExt
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeSearchCompleteSpec extends Specification {

  //       18
  //   15      30
  // 14  16  29  31
  @Shared
  def level1BothFull = [18, 15, 30, 29, 14, 31, 16]

  //                20
  //        15             30
  //   9        18      29    31
  // 8  10    17
  @Shared
  def level2LeftLeaning = [18, 15, 30, 29, 31, 9, 18, 8, 10, 17]

  @Unroll
  def 'isCompleteBinaryTree #scenario'() {
    given:
    def binaryTree = new IntBinaryTree(numbers)

    expect:
    BinarySearchExt.INSTANCE.isCompleteBinaryTree(binaryTree)

    where:
    scenario               | numbers
    '1 level both full'    | level1BothFull
    '2 level left leaning' | level2LeftLeaning
  }

  def 'isCompleteBinaryTree incorrect with right leaning'() {
    given:
    def numbers = [18, 15, 30, 29, 31, 9, 18, 8, 10, 19]

    def binaryTree = new IntBinaryTree(numbers)

    expect:
    !BinarySearchExt.INSTANCE.isCompleteBinaryTree(binaryTree)
  }
}
