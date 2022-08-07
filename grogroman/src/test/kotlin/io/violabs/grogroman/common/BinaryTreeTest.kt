package io.violabs.grogroman.common

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class BinaryTreeTest {
  private val items: MutableList<Int> = mutableListOf(8, 4, 9, 12, 5, 1, 10, 20)
  private val objectMapper = ObjectMapper()

  @Test
  fun test() {
    val binaryTree = BinaryTree(items, comparator = Int::compareTo)

    binaryTree.print()

    items.forEachIndexed { i, int ->
      Assertions.assertEquals(i, binaryTree.find(int))
    }
  }

  @Test
  fun testBuildOfBinaryTree() {
    val expected = """{"list":[],"root":null}"""

    val binaryTree = BinaryTree<Int>(mutableListOf(), comparator =  Int::compareTo)

    val actual: String = objectMapper.writeValueAsString(binaryTree)

    println("EXPECTED: $expected")
    println("ACTUAL:   $actual")

    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun testBuildOfSingleLevelBinaryTree() {
    val file = File("./src/test/resources/single-level-binary-tree.json")

    val expected = file.readLines().joinToString("", transform = String::trim).replace(" ", "")

    val binaryTree = BinaryTree(mutableListOf(9), comparator = Int::compareTo)

    val actual: String = objectMapper.writeValueAsString(binaryTree)

    println("EXPECTED: $expected")
    println("ACTUAL:   $actual")

    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun testBuildOfLevel2BinaryTree() {
    val file = File("./src/test/resources/level-2-binary-tree.json")

    val expected =
      file
        .readLines()
        .joinToString("", transform = String::trim)
        .replace(" ", "")

    val binaryTree = BinaryTree(mutableListOf(9, 7, 11), comparator = Int::compareTo)

    val actual: String = objectMapper.writeValueAsString(binaryTree)

    println("EXPECTED: $expected")
    println("ACTUAL:   $actual")

    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun testBuildOfLevel3BinaryTree() {
    val file = File("./src/test/resources/level-3-binary-tree.json")

    val expected =
      file
        .readLines()
        .joinToString("", transform = String::trim)
        .replace(" ", "")

    val binaryTree = BinaryTree(mutableListOf(9, 7, 11, 6, 12, 8), comparator = Int::compareTo)

    val actual: String = objectMapper.writeValueAsString(binaryTree)

    println("EXPECTED: $expected")
    println("ACTUAL:   $actual")

    Assertions.assertEquals(expected, actual)
  }
}