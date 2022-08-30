package io.violabs.grogroman.hackerrank

import java.time.LocalTime
import java.time.format.DateTimeFormatter

object TimeConversion {

  fun run(time: String): String =
    LocalTime
      .parse(time, INBOUND_FORMATTER)
      .format(OUTBOUND_FORMATTER)

  private val INBOUND_FORMATTER = DateTimeFormatter.ofPattern("hh:mm:ssa")
  private val OUTBOUND_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss")
}