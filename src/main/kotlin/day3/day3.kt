package day3

import utils.Input
import utils.Input.Day

class Day3 {

    private val Char.toValue: Int
        get() =
            when (this) {
                in 'a'..'z' -> this - 'a' + 1
                in 'A'..'Z' -> this - 'A' + 27
                else -> Int.MIN_VALUE
            }

    fun part2(lines: List<String>): Int {
        var sum = 0
        var index = 0
        while (index < lines.lastIndex) {
            val line1 = lines[index++].toSet()
            val line2 = lines[index++].toSet()
            val line3 = lines[index++].toSet()
            val common = line1.intersect(line2).intersect(line3)
            sum += common.first().toValue
        }
        return sum
    }


    fun part1(lines: List<String>): Int {
        var sum = 0
        lines.map { line ->
            val midPoint = line.length / 2
            val compartment1 = line.subSequence(0, midPoint).toSet()
            val compartment2 = line.subSequence(midPoint, line.length).toSet()
            val common = compartment1.intersect(compartment2)
            sum += common.first().toValue
        }
        return sum
    }
}

fun main() {
    val input = Input(Day.DAY3).getLines()

    println("Part 1: ${Day3().part1(input)}")
    println("Part 2: ${Day3().part2(input)}")
}
