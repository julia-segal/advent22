package sample

import utils.Grid
import utils.Input
import utils.Input.Day
import utils.Item

class Sample {

    private fun Grid<String>.explode() {
        val explosive = Item("X")
        val explosives = find(explosive)
        explosives.keys.map {
            putAboveLeft(it, Item("X"))
            putAbove(it, Item("X"))
            putAboveRight(it, Item("X"))
            putLeft(it, Item("X"))
            putRight(it, Item("X"))
            putBelowLeft(it, Item("X"))
            putBelow(it, Item("X"))
            putBelowRight(it, Item("X"))
        }
    }

    fun calculate(lines: List<String>): Grid<String> {
        val grid = Grid<String>()
        lines.map { line ->
            grid.addRow(line.split(' ').map { Item(it) })
        }
        grid.explode()
        return grid
    }
}

fun main() {
    val input = Input(Day.SAMPLE).getLines()
    println("Input:")
    input.map { println(it) }

    val results = Sample().calculate(input)
    println("\nResults:\n$results")
}
