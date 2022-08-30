package io.violabs.grogroman.common

fun <T> T.print(): T = this.also {
  println(it)
}