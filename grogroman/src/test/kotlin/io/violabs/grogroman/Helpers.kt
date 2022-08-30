package io.violabs.grogroman

import org.junit.jupiter.api.Assertions

fun <T> Array<T>.testEquals(other: Array<T>) =
  this.zip(other).forEach { (a, b) -> Assertions.assertEquals(a, b) }