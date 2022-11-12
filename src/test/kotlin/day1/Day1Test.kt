package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1Test {

    private val sut = Day1()

    @Test
    fun day1() {
        val expected = "THIS"
        val input = listOf("THIS WILL BE THE DATA")

        val actual = sut.calculate(input)

        assertEquals(expected, actual)
    }
}
