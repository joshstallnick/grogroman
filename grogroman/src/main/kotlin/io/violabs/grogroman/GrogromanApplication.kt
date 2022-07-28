package io.violabs.grogroman

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrogromanApplication

fun main(args: Array<String>) {
	runApplication<GrogromanApplication>(*args)
}