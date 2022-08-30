package io.violabs.grogroman.hackerrank

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CompareTripletsTest {

  @Test
  fun test1() = shared(
    alice = arrayOf(5, 6, 7),
    bob = arrayOf(3, 6, 10),
    expected = arrayOf(1, 1)
  )

  //17 28 30
  //99 16 8
  @Test
  fun test2() = shared(
    alice = arrayOf(17, 28, 30),
    bob = arrayOf(99, 16, 8),
    expected = arrayOf(2, 1)
  )

  private fun shared(
    alice: Array<Int>,
    bob: Array<Int>,
    expected: Array<Int>
  ) {
    //when
    val actual: Array<Int> = CompareTriplets.compare(alice, bob)

    //then
    expected.zip(actual).forEach { (e, a) -> Assertions.assertEquals(e, a) }
  }
}