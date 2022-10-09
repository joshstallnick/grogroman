package io.violabs.grogroman.hackerrank

object GradingStudents {

  fun run(grades: Array<Int>): Array<Int> =
    grades
      .asSequence()
      .map(this::roundIfNeeded)
      .toList()
      .toTypedArray()

  private fun roundIfNeeded(grade: Int): Int {
    if (grade < 38) return grade

    val remainder: Int = grade % 5

    if (remainder < 3) return grade

    return grade + (5 - remainder)
  }
}