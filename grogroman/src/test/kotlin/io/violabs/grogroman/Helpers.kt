package io.violabs.grogroman

import org.junit.jupiter.api.Assertions

fun <T> List<T>.testEquals(actual: Array<T>) = Assertions.assertEquals(this, actual.toList())

fun <T> T.testEquals(actual: T) = Assertions.assertEquals(this, actual)