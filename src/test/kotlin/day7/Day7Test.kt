package day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day7Test {

    private val sut = Day7()

    private val input: List<String>
        get() {
            val input = "\$ cd /\n" +
                    "\$ ls\n" +
                    "dir a\n" +
                    "14848514 b.txt\n" +
                    "8504156 c.dat\n" +
                    "dir d\n" +
                    "\$ cd a\n" +
                    "\$ ls\n" +
                    "dir e\n" +
                    "29116 f\n" +
                    "2557 g\n" +
                    "62596 h.lst\n" +
                    "\$ cd e\n" +
                    "\$ ls\n" +
                    "584 i\n" +
                    "\$ cd ..\n" +
                    "\$ cd ..\n" +
                    "\$ cd d\n" +
                    "\$ ls\n" +
                    "4060174 j\n" +
                    "8033020 d.log\n" +
                    "5626152 d.ext\n" +
                    "7214296 k"
            return input.split('\n')
        }

    @Test
    fun part1() {
        val expected = 95437

        val actual = sut.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected = 24933642

        val actual = sut.part2(input)

        assertEquals(expected, actual)
    }
}
