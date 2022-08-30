package io.violabs.grogroman.hackerrank

import java.math.RoundingMode

object PlusMinus {

  fun run(array: Array<Int>): Array<Double> {
    val spectrum = SignSpectrum()

    array.forEach(spectrum::addNumber)

    return spectrum.asRatios(array.size)
  }

  private class SignSpectrum {
    private var positive: Int = 0
    private var zero: Int = 0
    private var negative: Int = 0

    fun addNumber(n: Int) {
      when {
        n > 0 -> positive++
        n < 0 -> negative++
        else  -> zero++
      }
    }

    fun asRatios(size: Int): Array<Double> = arrayOf(
      positive.precisionDivide(size),
      negative.precisionDivide(size),
      zero.precisionDivide(size)
    )

    private fun Int.precisionDivide(n: Int): Double =
      (this / n.toDouble())
        .toBigDecimal()
        .setScale(6, RoundingMode.HALF_UP)
        .toDouble()
  }
}