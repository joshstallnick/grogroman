package io.violabs.grogroman.hackerrank

object BreakingBestAndWorstRecords {

    fun run(scores: Array<Int>): List<Int> {
        val minMax = MinMax(scores[0])

        scores
            .asSequence()
            .drop(1)
            .forEach(minMax::check)

        return minMax.counts()
    }

    class MinMax(start: Int) {
        var min: Int = 0
        var max: Int = 0

        var minCount: Int = 0
        var maxCount: Int = 0

        init {
            min = start
            max = start
        }

        fun counts(): List<Int> = listOf(maxCount, minCount)

        fun check(score: Int) {
            if (score < min) return addMin(score)

            if (score > max) return addMax(score)
        }

        private fun addMin(score: Int) {
            min = score
            minCount++
        }

        private fun addMax(score: Int) {
            max = score
            maxCount++
        }
    }
}