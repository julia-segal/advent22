package day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day5Test {

    private val sut = Day5()

    private val input: List<String>
        get() {
            val input = "    [D]    \n" +
                    "[N] [C]    \n" +
                    "[Z] [M] [P]\n" +
                    " 1   2   3 \n" +
                    "\n" +
                    "move 1 from 2 to 1\n" +
                    "move 3 from 1 to 3\n" +
                    "move 2 from 2 to 1\n" +
                    "move 1 from 1 to 2"
            return input.split('\n')
        }

    @Test
    fun part1() {
        val expected = "CMZ"

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = "MCD"

        val actual = sut.part2(input)

        assertEquals(expected, actual)
    }
}
