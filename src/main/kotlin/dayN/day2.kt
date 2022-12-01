package dayN

import utils.Input
import utils.Input.Day

class DayN {

    fun part2(lines: List<String>) {
    }

    fun part1(lines: List<String>) {
    }
}

fun main() {
    val input = Input(Day.DAY1).getLines()
    println("Input: $input")

    val results = DayN().part1(input)
    println("Results: $results")

    val results2 = DayN().part2(input)
    println("Results: $results2")
}
