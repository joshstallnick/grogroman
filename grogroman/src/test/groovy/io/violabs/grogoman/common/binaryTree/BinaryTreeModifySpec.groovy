package io.violabs.grogoman.common.binaryTree

import com.fasterxml.jackson.databind.ObjectMapper
import io.violabs.grogroman.common.binaryTree.IntBinaryTree
import io.violabs.grogroman.common.test.FileHelper
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeModifySpec extends Specification {
  def objectMapper = new ObjectMapper()

  @Unroll
  def 'add #addedNumber to tree with #initialList'() {
    given:
    def tree = new IntBinaryTree(initialList)

    String expected = FileHelper.INSTANCE.fileAsJsonString(filename)

    when:
    tree.add(addedNumber)

    then:
    String actual = objectMapper.writeValueAsString(tree)
    println("EXPECTED: $expected")
    println("ACTUAL:   $actual")
    expected == actual

    where:
    scenario  | filename                                        | initialList       | addedNumber
    'level 1' | './src/test/resources/level-1-binary-tree.json' | []                | 9
    'level 2' | './src/test/resources/level-2-binary-tree.json' | [9, 7]            | 11
    'level 3' | './src/test/resources/level-3-binary-tree.json' | [9, 7, 11, 6, 12] | 8
  }
}
