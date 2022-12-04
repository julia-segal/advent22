package day4

import utils.Input
import utils.Input.Day

class Day4 {

    fun part2(lines: List<String>):Int {
        var count = 0
        lines.map { line ->
            val ranges = line.split(',')
            val r1 = ranges[0].split('-')
            val r2 = ranges[1].split('-')
            when{
                r1[0].toInt() in r2[0].toInt()..r2[1].toInt() -> count++
                r1[1].toInt() in r2[0].toInt()..r2[1].toInt() -> count++
                r2[0].toInt() in r1[0].toInt()..r1[1].toInt() -> count++
                r2[1].toInt() in r1[0].toInt()..r1[1].toInt() -> count++
                else -> {}
            }
        }
        return count
    }

    fun part1(lines: List<String>):Int {
        var count = 0
        lines.map { line ->
            val ranges = line.split(',')
            val r1 = ranges[0].split('-')
            val r2 = ranges[1].split('-')
            when {
                r1[0].toInt() <= r2[0].toInt() && r1[1].toInt() >= r2[1].toInt() -> count++
                r1[0].toInt() >= r2[0].toInt() && r1[1].toInt() <= r2[1].toInt() -> count++
                else -> {}
            }
        }
        return count
    }
}

fun main() {
    val input = Input(Day.DAY4).getLines()

    println("Part 1: ${Day4().part1(input)}")
    println("Part 2: ${Day4().part2(input)}")
}
