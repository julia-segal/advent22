package day6

import utils.Input
import utils.Input.Day

class Day6 {

    private fun findSignalIndex(line: String, step: Int): Int? {
        var start = 0
        while(start < line.length + step) {
            if (line.subSequence(start, start + step).toSet().distinct().size == step) {
                return start + step
            } else {
                start++
            }
        }
        return null
    }

    fun part1(lines: List<String>): List<Int?> = lines.map { findSignalIndex(it, 4) }.toList()

    fun part2(lines: List<String>): List<Int?> = lines.map { findSignalIndex(it, 14) }.toList()
}

fun main() {
    val input = Input(Day.DAY6).getLines()

    println("Part 1: ${Day6().part1(input)}")
    println("Part 2: ${Day6().part2(input)}")
}
