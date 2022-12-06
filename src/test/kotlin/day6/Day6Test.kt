package day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day6Test {

    private val sut = Day6()

    private val input: List<String>
        get() {
            val input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb5\n" +
                    "bvwbjplbgvbhsrlpgdmjqwftvncz\n" +
                    "nppdvjthqldpwncqszvftbrmjlhg\n" +
                    "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg\n" +
                    "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
            return input.split('\n')
        }

    @Test
    fun part1() {
        val expected = listOf(7, 5, 6, 10, 11)

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = listOf(19, 23, 23, 29, 26)

        val actual = sut.part2(input)

        assertEquals(expected, actual)
    }
}
