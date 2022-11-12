package utils

import java.lang.StringBuilder

class Grid<T> {

    var maxX = 0
        private set
    var maxY = 0
        private set
    private var currentY: Int = 0
    private val grid: HashMap<Point, Item<T>> = HashMap()

    val dimens: Pair<Int, Int>
        get() = Pair(maxX, maxY)

    fun addRow(items: List<Item<T>>) {
        var currentX = 0
        items.map {
            grid[Point(currentX, currentY)] = it
            currentX++
            if (currentX >= maxX) maxX = currentX
        }
        currentY++
        if (currentY >= maxY) maxY = currentY
    }

    fun findItem(item: Item<T>): Map<Point, Item<T>> =
        grid.filterValues { it.value == item.value }

    fun itemAt(point: Point): Item<T>? = grid[point]

    fun putItemAt(point: Point, item: Item<T>) {
        if ((point.x < maxX) && (point.y < maxY))
            grid[point] = item
    }

    fun forEach( doIt: (value: T )-> T) {
        for (y in 0 until maxY) {
            for (x in 0 until maxX) {
                val item = itemAt(Point(x, y))
                item?.let {
                    val newValue = doIt(item.value)
                    putItemAt(Point(x, y), Item(newValue))
                }
            }
        }
    }

    fun toRows(): List<List<Item<T>>> {
        val rows = mutableListOf<List<Item<T>>>()
        for (y in 0 until maxY) {
            val row = mutableListOf<Item<T>>()
            for (x in 0 until maxX) {
                val item = grid[Point(x, y)]
                item?.let { row.add(item) }
            }
            rows.add(row)
        }
        return rows
    }

    fun toColumns(): List<List<Item<T>>> {
        val columns = mutableListOf<List<Item<T>>>()
        for (x in 0 until maxX) {
            val column = mutableListOf<Item<T>>()
            for (y in 0 until maxY) {
                val item = grid[Point(x, y)]
                item?.let { column.add(item) }
            }
            columns.add(column)
        }
        return columns
    }

    override fun toString(): String {
        val output = StringBuilder()
        for (y in 0 until maxY) {
            for (x in 0 until maxX) {
                val item = grid[Point(x, y)]?.value
                item?.let { output.append("${item.toString()} ") }
            }
            output.append("\n")
        }
        output.append("\n")
        return output.toString()
    }
}
