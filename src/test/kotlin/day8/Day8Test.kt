package day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day8Test {

    private val sut = Day8()

    private val input: List<String>
        get() {
            val input = ""
            return input.split('\n')
        }

    @Test
    fun part1() {
        val expected = 0

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 0

        val actual = sut.part2(input)

        assertEquals(expected, actual)
    }
}
