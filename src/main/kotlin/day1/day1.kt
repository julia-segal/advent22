package day1

import utils.Input
import utils.Input.Companion.items
import utils.Input.Day

class Day1 {

    fun calculate(lines: List<String>): String? = lines.items().firstOrNull()
}

fun main() {
    val input = Input(Day.DAY1).getLines()
    println("Input: $input")

    val results = Day1().calculate(input)
    println("Results: $results")
}
