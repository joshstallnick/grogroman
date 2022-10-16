package io.violabs.grogroman.hackerrank

typealias CountEntry = Map.Entry<Int, List<Int>>

fun CountEntry.hasBiggerCountThan(other: CountEntry): Boolean = this.value.size > other.value.size
fun CountEntry.hasSameCountAs(other: CountEntry): Boolean = this.value.size == other.value.size
fun CountEntry.hasSmallerKeyThan(other: CountEntry): Boolean = this.key < other.key

object MigratoryBirds {

    fun run(arr: Array<Int>): Int {
        val comparator: Comparator<Map.Entry<Int, List<Int>>> = Comparator { o1, o2 ->
            val check: Boolean = o1.hasBiggerCountThan(o2) || o1.hasSameCountAs(o2) && o1.hasSmallerKeyThan(o2)

            if (check) 1 else -1
        }

        return arr
            .groupBy { it }
            .asSequence()
            .sortedWith(comparator)
            .last()
            .key
    }
}