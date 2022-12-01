package dayN

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayNTest {

    private val sut = DayN()

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
    fun part2() {        val expected = 0

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }
}
