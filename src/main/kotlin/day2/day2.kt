package day2

import utils.Input
import utils.Input.Day
import kotlin.Int.Companion.MIN_VALUE

class Day2 {

    private val LOSE = 0
    private val DRAW = 3
    private val WIN = 6

    private val Char.toWeapon: Int
        get() =
            when (this) {
                'A', 'X' -> 1
                'B', 'Y' -> 2
                'C', 'Z' -> 3
                else -> MIN_VALUE
            }

    private val Char.toOutcome: Int
        get() =
            when (this) {
                'X' -> LOSE
                'Y' -> DRAW
                'Z' -> WIN
                else -> MIN_VALUE
            }

    private val Int.betterWeapon: Int
        get() =
            when (this) {
                1 -> 2
                2 -> 3
                3 -> 1
                else -> MIN_VALUE
            }

    private val Int.worseWeapon: Int
        get() =
            when (this) {
                1 -> 3
                2 -> 1
                3 -> 2
                else -> MIN_VALUE
            }

    private fun Int.getOutcomeWeapon(elf: Int): Int =
        when (this) {
            WIN -> elf.betterWeapon
            LOSE -> elf.worseWeapon
            DRAW -> elf
            else -> MIN_VALUE
        }

    private fun fight(me: Int, elf: Int): Int =
        when {
            me - elf == 1 -> WIN
            me == 1 && elf == 3 -> WIN
            me == elf -> DRAW
            else -> LOSE
        }

    fun part2(lines: List<String>): Int {
        var score = 0

        lines.map {
            val elf = it.first().toWeapon
            val me = it.last().toOutcome.getOutcomeWeapon(elf)
            score += me + fight(me, elf)
        }
        return score
    }

    fun part1(lines: List<String>): Int {
        var score = 0

        lines.map {
            val elf = it.first().toWeapon
            val me = it.last().toWeapon
            score += me + fight(me, elf)
        }
        return score
    }
}

fun main() {
    val input = Input(Day.DAY2).getLines()

    println("Part 1: ${Day2().part1(input)}")
    println("Part 2: ${Day2().part2(input)}")
}
