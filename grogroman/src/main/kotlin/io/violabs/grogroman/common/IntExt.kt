package io.violabs.grogroman.common

operator fun Int.not(): Int = (1..this).reduce(Int::times)