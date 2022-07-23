package io.violabs.grogroman

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.math.sqrt

@SpringBootApplication
class GrogromanApplication

fun main(args: Array<String>) {
	val sqrtList: List<Float> =
		(0..10_000)
			.asSequence()
			.map(Int::toFloat)
			.map(::sqrt)
			.toList()

	val total: Float =
		sqrtList
			.onEach(::println)
			.sum()

	println("Total: $total")

	runApplication<GrogromanApplication>(*args)
}