package io.violabs.grogroman.hackerrank

object AppleAndOrange {

  fun run(parameters: Parameters): Pair<Int, Int> {
    return run(
      parameters.houseLeft,
      parameters.houseRight,
      parameters.leftTree,
      parameters.rightTree,
      parameters.apples,
      parameters.oranges
    )
  }

  fun run(s: Int, t: Int, a: Int, b: Int, apples: List<Int>, oranges: List<Int>): Pair<Int, Int> {
    val house = House(s, t)

    val appleTree = Tree(a, apples)

    house.applesHit = appleTree.countFruitDroppedIf(house.range::contains)

    val orangeTree = Tree(b, oranges)

    house.orangesHit = orangeTree.countFruitDroppedIf(house.range::contains)

    return house.fruitHitCounts()
  }

  class House(val left: Int, val right: Int, var applesHit: Int = 0, var orangesHit: Int = 0) {
    val range: IntRange = (left..right)

    fun fruitHitCounts(): Pair<Int, Int> = Pair(applesHit, orangesHit)
  }

  class Tree(private val position: Int, private val fruitDropPositions: List<Int>) {
    fun countFruitDroppedIf(compare: (Int) -> Boolean): Int =
      fruitDropPositions
        .asSequence()
        .map(position::plus)
        .filter { compare.invoke(it) }
        .count()
  }

  class Parameters(
    val houseLeft: Int,
    val houseRight: Int,
    val leftTree: Int,
    val rightTree: Int,
    val apples: List<Int>,
    val oranges: List<Int>
  )
}