package io.violabs.grogoman.common.binaryTree

import io.violabs.grogroman.common.binaryTree.BinaryTreeCalculator
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeCalculatorSpec extends Specification {

  @Unroll
  def maxNodesAtLevel() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.maxNodesAtLevel(level)

    then:
    expected == actual

    where:
    level | expected
    -1    | 0
     0    | 1
     1    | 2
     2    | 4
     4    | 16
     8    | 256
  }

  @Unroll
  def maxNodesAtHeight() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.maxNodesAtHeight(height)

    then:
    expected == actual

    where:
    height | expected
    -1     | 0
     0     | 0
     1     | 1
     2     | 3
     4     | 15
     8     | 255
  }

  @Unroll
  def minLevelsForNumberOfNodes() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.minLevelsForNumberOfNodes(amount)

    then:
    expected == actual

    where:
    amount | expected
    -1     | 0
     0     | 0
     1     | 1
     2     | 2
     4     | 3
     8     | 4
  }

  @Unroll
  def minHeightForNumberOfNodes() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.minHeightForNumberOfNodes(amount)

    then:
    expected == actual

    where:
    amount | expected
    -1     | 0
     0     | 0
     1     | 1
     2     | 2
     4     | 3
     8     | 4
  }

  @Unroll
  def minLevelsForNumberOfLeaves() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.minLevelsForNumberOfLeaves(amount)

    then:
    expected == actual

    where:
    amount | expected
    -1     | 0
     0     | 0
     1     | 1
     2     | 2
     4     | 3
     8     | 4
  }

  @Unroll
  def numberOfNodesWithTwoChildren() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.numberOfNodesWithTwoChildren(height)

    then:
    expected == actual

    where:
    height | expected
    -1     | 0
     0     | 0
     1     | 0
     2     | 2
     4     | 14
     8     | 254
  }

  @Unroll
  def numberOfEdgesByNodeAmount() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.numberOfEdgesByNodeAmount(height)

    then:
    expected == actual

    where:
    height | expected
    -1     | 0
     0     | 0
     1     | 0
     2     | 1
     4     | 3
     8     | 7
  }

  @Unroll
  def numberOfNodesByEdgeAmount() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.numberOfNodesByEdgeAmount(height)

    then:
    expected == actual

    where:
    height | expected
    -1     | 0
     0     | 0
     1     | 2
     2     | 3
     4     | 5
     8     | 9
  }

  def numberOfLabelledTrees() {
    when:
    int actual = BinaryTreeCalculator.INSTANCE.numberOfLabelledTrees(5, 3)

    then:
    30 == actual
  }
}
