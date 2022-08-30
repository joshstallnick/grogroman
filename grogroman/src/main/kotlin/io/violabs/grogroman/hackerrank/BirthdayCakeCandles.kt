package io.violabs.grogroman.hackerrank

import java.util.concurrent.atomic.AtomicInteger

object BirthdayCakeCandles {

  fun run(candles: Array<Int>): Int {
    val count = AtomicInteger(0)

    val sortedArray: Array<Int> = candles.sortedArrayDescending()

    val max: Int = sortedArray[0]

    sortedArray
      .forEach {
        if (it != max) return@forEach

        count.incrementAndGet()
      }

    return count.get()
  }
}