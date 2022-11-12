package utils

import java.lang.StringBuilder

class Grid<T> {

    private var maxX = 0
    private var maxY = 0
    private var currentX: Int = 0
    private var currentY: Int = 0

    private val grid: HashMap<Point, Item<T>> = HashMap()

    fun addRow(items: List<Item<T>>) {
        items.map {
            grid[Point(currentX, currentY)] = it
            currentX++
            if (currentX >= maxX) maxX = currentX
        }
        currentX = 0
        currentY++
        if (currentY >= maxY) maxY = currentY
    }

    fun item(point: Point): Item<T>? = grid[point]

    fun changeItem(point: Point, item: Item<T>) {
        if ((point.x < maxX) && (point.y < maxY))
            grid[point] = item
    }


    fun find(item: Item<T>): Map<Point, Item<T>> =
        grid.filterValues { it.value == item.value }

    fun above(point: Point): Item<T>? = grid[Point(point.x, point.y - 1)]
    fun putAbove(point: Point, item: Item<T>) {
        changeItem(Point(point.x, point.y - 1), item)
    }

    fun aboveLeft(point: Point): Item<T>? = grid[Point(point.x - 1, point.y - 1)]
    fun putAboveLeft(point: Point, item: Item<T>) {
        changeItem(Point(point.x - 1, point.y - 1), item)
    }

    fun aboveRight(point: Point): Item<T>? = grid[Point(point.x + 1, point.y - 1)]
    fun putAboveRight(point: Point, item: Item<T>) {
        changeItem(Point(point.x + 1, point.y - 1), item)
    }

    fun below(point: Point): Item<T>? = grid[Point(point.x, point.y + 1)]
    fun putBelow(point: Point, item: Item<T>) {
        changeItem(Point(point.x, point.y + 1), item)
    }

    fun belowLeft(point: Point): Item<T>? = grid[Point(point.x - 1, point.y + 1)]
    fun putBelowLeft(point: Point, item: Item<T>) {
        changeItem(Point(point.x - 1, point.y + 1), item)
    }

    fun belowRight(point: Point): Item<T>? = grid[Point(point.x + 1, point.y + 1)]
    fun putBelowRight(point: Point, item: Item<T>) {
        changeItem(Point(point.x + 1, point.y + 1), item)
    }

    fun left(point: Point): Item<T>? = grid[Point(point.x - 1, point.y)]
    fun putLeft(point: Point, item: Item<T>) {
        changeItem(Point(point.x - 1, point.y), item)
    }

    fun right(point: Point): Item<T>? = grid[Point(point.x + 1, point.y)]
    fun putRight(point: Point, item: Item<T>) {
        changeItem(Point(point.x + 1, point.y), item)
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