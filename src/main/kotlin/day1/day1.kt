package day1

import utils.Input
import utils.Input.Day

class Day1 {

    private fun List<String>.toCalories(): List<Int> {
        val caloriePacks = mutableListOf<Int>()
        var calorie = 0
        this.map {
            if (it.isNotEmpty()) {
                calorie += it.toInt()
            } else {
                caloriePacks.add(calorie)
                calorie = 0
            }
        }
        if (calorie != 0) caloriePacks.add(calorie)
        return caloriePacks.sorted()
    }

    fun part2(lines: List<String>): Int = lines.toCalories().takeLast(3).sum()

    fun part1(lines: List<String>): Int = lines.toCalories().last()
}

fun main() {
    val input = Input(Day.DAY1).getLines()

    println("Part 1: ${Day1().part1(input)}")
    println("Part 2: ${Day1().part2(input)}")
}
