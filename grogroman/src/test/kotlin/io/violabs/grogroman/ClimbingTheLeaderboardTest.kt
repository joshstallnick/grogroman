package io.violabs.grogroman

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClimbingTheLeaderboardTest {

  @Test
  fun firstTest() {
    //given
    val ranked: Array<Int> = arrayOf(100, 100, 50, 40, 40, 20, 10)

    val player: Array<Int> = arrayOf(5, 25, 50, 120)

    val expected: Array<Int> = arrayOf(6, 4, 2, 1)

    //when
    val actual: Array<Int> = ClimbingTheLeaderboard.run(ranked, player)

    //then
    Assertions.assertEquals(expected.toList(), actual.toList())
  }

  @Test
  fun secondTest() {
    //given
    val ranked: Array<Int> = arrayOf(100, 90, 90, 80, 75, 60)

    val player: Array<Int> = arrayOf(50, 65, 77, 90, 102)

    val expected: Array<Int> = arrayOf(6, 5, 4, 2, 1)

    //when
    val actual: Array<Int> = ClimbingTheLeaderboard.run(ranked, player)

    //then
    Assertions.assertEquals(expected.toList(), actual.toList())
  }

  @Test
  fun thirdTest() {
    //given
    val ranked: Array<Int> = arrayOf(100, 5)

    val player: Array<Int> = arrayOf(5, 100)

    val expected: Array<Int> = arrayOf(2, 1)

    //when
    val actual: Array<Int> = ClimbingTheLeaderboard.run(ranked, player)

    //then
    Assertions.assertEquals(expected.toList(), actual.toList())
  }
}