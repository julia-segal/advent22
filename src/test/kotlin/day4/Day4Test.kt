package day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day4Test {

    private val sut = Day4()

    private val input: List<String>
        get() {
            val input = "2-4,6-8\n" +
                    "2-3,4-5\n" +
                    "5-7,7-9\n" +
                    "2-8,3-7\n" +
                    "6-6,4-6\n" +
                    "2-6,4-8"
            return input.split('\n')
        }

    @Test
    fun part1() {
        val expected = 2

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 4

        val actual = sut.part2(input)

        assertEquals(expected, actual)
    }
}
