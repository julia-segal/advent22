package sample

import utils.*
import utils.Input.Day

/*
This is a bullshit sample:
Convert X to *
When an X is found, convert all adjacent items to X
Then add one to anything left

            "16 2 3 X 9",
            "2 3 4 5 6",
            "8 8 8 8 X"

            becomes

            "17 3 X * X",
            "3 4 X X X",
            "9 9 9 X *"

 */

class Sample {

    private fun Grid<String>.explode() {
        /* Turn adjacent character to an X to X, turn original X to * */
        val x = Item("X")
        val star = Item("*")
        val explosives = findItem(x)
        explosives.keys.map { point ->
            putItemAt(point.above().left(), x)
            putItemAt(point.above(), x)
            putItemAt(point.above().right(), x)
            putItemAt(point.left(), x)
            putItemAt(point.right(), x)
            putItemAt(point.below().left(), x)
            putItemAt(point.below(), x)
            putItemAt(point.below().right(), x)
            putItemAt(point, star)
        }
    }

    private fun String.add(amount: Int): String = toIntOrNull()?.let { (it + amount).toString() } ?: this

    fun calculate(lines: List<String>): Grid<String> {
        val grid = Grid<String>()
        lines.map { line -> grid.addRow(line.split(' ').map { Item(it) }) }

        grid.explode()
        grid.forEach { it.add(1) }

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
