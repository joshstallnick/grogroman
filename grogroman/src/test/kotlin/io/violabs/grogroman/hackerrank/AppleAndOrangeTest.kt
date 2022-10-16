package io.violabs.grogroman.hackerrank

import io.violabs.grogroman.TestHarness
import org.junit.jupiter.api.Test
import java.io.File

class AppleAndOrangeTest : TestHarness() {

  private val classLoader: ClassLoader = javaClass.classLoader

  private val applesArrayStringLocation: String = "hackerrank/applesAndOranges/apples.txt"
  private val orangesArrayStringLocation: String = "hackerrank/applesAndOranges/oranges.txt"

  @Test
  fun testRun1() = test {
    expect { Pair(1, 1) }

    whenever {
      val parameters = AppleAndOrange.Parameters(
        7,
        11,
        5,
        15,
        listOf(-2, 2, 1),
        listOf(5, -6)
      )

      AppleAndOrange.run(parameters)
    }
  }

  @Test
  fun testRun2() = test {
    expect { Pair(0, 0) }

    whenever {
      val parameters = AppleAndOrange.Parameters(
        2,
        3,
        1,
        5,
        listOf(-2),
        listOf(-1)
      )

      AppleAndOrange.run(parameters)
    }
  }

  @Test
  fun testRun3() = test {
    expect { Pair(18_409, 19_582) }

    whenever {
      val apples: List<Int> = applesArrayStringLocation.extractNumberList()
      val oranges: List<Int> = orangesArrayStringLocation.extractNumberList()

      val parameters = AppleAndOrange.Parameters(
        37_455,
        87_275,
        35_609,
        89_610,
        apples,
        oranges
      )

      AppleAndOrange.run(parameters)
    }
  }

  //File file = new File(classLoader.getResource("somefile").getFile());
  private fun String.extractNumberList(): List<Int> =
    classLoader
      .getResource(this)
      ?.file
      ?.let(::File)
      ?.readLines()
      ?.asSequence()
      ?.map { it.split(" ") }
      ?.flatten()
      ?.map(String::toInt)
      ?.toList()
      ?: listOf()
}