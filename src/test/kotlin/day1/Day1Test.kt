package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1Test {

    private val sut = Day1()

    private val input: List<String>
        get() {
            val input =
                "1000\n" +
                        "2000\n" +
                        "3000\n" +
                        "\n" +
                        "4000\n" +
                        "\n" +
                        "5000\n" +
                        "6000\n" +
                        "\n" +
                        "7000\n" +
                        "8000\n" +
                        "9000\n" +
                        "\n" +
                        "10000"
            return input.split('\n')
        }

    @Test
    fun part1() {
        val expected = 24000

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 45000

        val actual = sut.part2(input)

        assertEquals(expected, actual)
    }
}
