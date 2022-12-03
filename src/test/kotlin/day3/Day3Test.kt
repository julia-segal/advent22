package day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day3Test {

    private val sut = Day3()

    private val input: List<String>
        get() {
            val input = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                    "PmmdzqPrVvPwwTWBwg\n" +
                    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                    "ttgJtRGJQctTZtZT\n" +
                    "CrZsJsPPZsGzwwsLwLmpwMDw"

            return input.split('\n')
        }

    @Test
    fun part1() {
        val expected = 157

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 70

        val actual = sut.part2(input)

        assertEquals(expected, actual)
    }

}
