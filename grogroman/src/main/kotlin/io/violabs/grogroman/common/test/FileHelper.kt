package io.violabs.grogroman.common.test

import java.io.File

object FileHelper {
  fun fileAsJsonString(filename: String): String =
    File(filename)
      .readLines()
      .joinToString("", transform = String::trim)
      .replace(" ", "")
}