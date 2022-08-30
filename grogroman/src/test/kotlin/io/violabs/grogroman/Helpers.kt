package io.violabs.grogroman

import org.junit.jupiter.api.Assertions

fun <T> List<T>.testEquals(other: Array<T>) = Assertions.assertEquals(this, other.toList())
fun <T> List<T>.testEquals(other: List<T>) = Assertions.assertEquals(this, other)