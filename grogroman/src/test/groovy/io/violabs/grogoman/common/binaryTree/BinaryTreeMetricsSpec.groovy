package io.violabs.grogoman.common.binaryTree

import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import spock.lang.Shared
import spock.lang.Specification

class BinaryTreeMetricsSpec extends Specification {

  @Shared
  def numbers = [100, 50, 150, 25, 75, 74, 76, 200, 300, 290, 299, 400]

  @Shared
  def binaryTree = new IntBinaryTree(numbers)

  def height() {
    when:
    int actual = binaryTree.height()

    then:
    6 == actual
  }

  def leftHeight() {
    when:
    int actual = binaryTree.leftHeight()

    then:
    4 == actual
  }

  def rightHeight() {
    when:
    int actual = binaryTree.rightHeight()

    then:
    6 == actual
  }

  def diameter() {
    when:
    int actual = binaryTree.diameter()

    then:
    9 == actual
  }
}
