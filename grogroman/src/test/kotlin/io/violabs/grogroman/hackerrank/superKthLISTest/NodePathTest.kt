package io.violabs.grogroman.hackerrank.superKthLISTest

import io.violabs.grogroman.hackerrank.superKthLIS.NodePath
import io.violabs.grogroman.testEquals
import org.junit.jupiter.api.Test

class NodePathTest {
  @Test
  fun `NodePath#flatten`() {
    //given
    val path = NodePath(
      1,
      NodePath(
        2,
        NodePath(3)
      )
    )

    val expected: List<Int> = listOf(1, 2, 3)

    //when
    val actual: List<Int> = NodePath.flatten(path)

    //then
    expected.testEquals(actual)
  }
}