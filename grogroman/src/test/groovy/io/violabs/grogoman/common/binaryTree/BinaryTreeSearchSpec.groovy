package io.violabs.grogoman.common.binaryTree

import com.fasterxml.jackson.databind.ObjectMapper
import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import io.violabs.grogroman.common.binaryTree.SearchExt
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeSearchSpec extends Specification {

  //region FULL BINARY
  @Unroll
  def 'isFullBinaryTree #scenario'() {
    given:
    IntBinaryTree binaryTree = new IntBinaryTree(numbers)

    expect:
    SearchExt.INSTANCE.isFullBinaryTree(binaryTree)

    where:
    scenario            | numbers
    '1 level both full' | [18, 15, 30, 29, 14, 31, 16]
    '2 level all left'  | [18, 13, 20, 14, 9, 11, 7]
    '1 level all right' | [18, 14, 20, 19, 21]
  }
  //endregion FULL BINARY
}
