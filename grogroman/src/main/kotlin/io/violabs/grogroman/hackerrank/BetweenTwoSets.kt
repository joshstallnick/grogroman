package io.violabs.grogroman.hackerrank

fun Int.isFactorOf(modCheck: Int): Boolean = modCheck % this == 0
fun Int.hasFactorOf(modBy: Int): Boolean = this % modBy == 0

object BetweenTwoSets {

    fun run(subFactors: Array<Int>, superFactors: Array<Int>): Int {
        val min: Int = subFactors.min()
        val max: Int = superFactors.min()

        return (min..max)
            .asSequence()
            .filter { checkSubFactors(it, subFactors) }
            .filter { checkSuperFactors(it, superFactors) }
            .count()
    }

    private fun checkSubFactors(n: Int, subFactors: Array<Int>): Boolean = subFactors.all(n::hasFactorOf)

    private fun checkSuperFactors(n: Int, superFactors: Array<Int>): Boolean = superFactors.all(n::isFactorOf)
}