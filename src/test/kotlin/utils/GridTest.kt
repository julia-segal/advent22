package utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test


internal class GridTest {

    @Test
    fun `add one row`() {
        val sut: Grid<String> = Grid()
        val row = "a b c d e f".split(' ').toItems()
        val expected = listOf("a", "b", "c", "d", "e", "f").toItems()

        sut.addRow(row)
        print(sut.toString())

        assertEquals(expected, sut.toRows().first())
    }

    @Test
    fun `add two row`() {
        val sut: Grid<String> = Grid()
        val row1 = "a b c d e f".split(' ').toItems()
        val row2 = "abc def ghi jkl mno pqr".split(' ').toItems()
        val expected = listOf(
            listOf("a", "b", "c", "d", "e", "f").toItems(),
            listOf("abc", "def", "ghi", "jkl", "mno", "pqr").toItems()
        )

        sut.addRow(row1)
        sut.addRow(row2)
        print(sut.toString())

        assertEquals(expected, sut.toRows())
    }

    @Test
    fun `add row of numbers`() {
        val expected =
            listOf(
                listOf(1,2,3,4,5).toItems(),
                listOf(2,3,4,5,6).toItems(),
                listOf(7,8,9,10,11).toItems()
            )

        val sut = makeIntGrid()

        assertEquals(expected, sut.toRows())
    }

    @Test
    fun `get above`() {
        val sut = makeIntGrid()

        val result = sut.above(Point(2,1))!!.value

        assertEquals(3, result)
    }

    @Test
    fun `get above left`() {
        val sut = makeIntGrid()

        val result = sut.aboveLeft(Point(2,2))!!.value

        assertEquals(3, result)
    }

    @Test
    fun `get above right`() {
        val sut = makeIntGrid()

        val result = sut.aboveRight(Point(2,2))!!.value

        assertEquals(5, result)
    }

    @Test
    fun `get below left`() {
        val sut = makeIntGrid()

        val result = sut.belowLeft(Point(1,1))!!.value

        assertEquals(7, result)
    }

    @Test
    fun `get below right`() {
        val sut = makeIntGrid()

        val result = sut.belowRight(Point(1,1))!!.value

        assertEquals(9, result)
    }


    @Test
    fun `get above is null`() {
        val sut = makeIntGrid()

        val result = sut.above(Point(2,0))

        assertNull( result)
    }

    @Test
    fun `get below`() {
        val sut = makeIntGrid()

        val result = sut.below(Point(2,1))!!.value

        assertEquals(9, result)
    }

    @Test
    fun `get below is null`() {
        val sut = makeIntGrid()

        val result = sut.below(Point(2,2))

        assertNull(result)
    }

    @Test
    fun `get left`() {
        val sut = makeIntGrid()

        val result = sut.left(Point(2,1))!!.value

        assertEquals(3, result)
    }

    @Test
    fun `get left is null`() {
        val sut = makeIntGrid()

        val result = sut.left(Point(0,2))

        assertNull(result)
    }

    @Test
    fun `get right`() {
        val sut = makeIntGrid()

        val result = sut.right(Point(2,1))!!.value

        assertEquals(5, result)
    }

    @Test
    fun `get right is null`() {
        val sut = makeIntGrid()

        val result = sut.right(Point(0,5))

        assertNull(result)
    }

    @Test
    fun `get item at`() {
        val sut = makeIntGrid()

        val result = sut.item(Point(3,2))!!.value

        assertEquals(10, result)
    }

    @Test
    fun `change item at`() {
        val sut = makeIntGrid()
        val oldValue = 10
        val newValue = -2

        val original = sut.item(Point(3,2))!!.value
        sut.changeItem(Point(3,2), Item(newValue))
        val changed = sut.item(Point(3,2))!!.value

        assertEquals(oldValue, original)
        assertEquals(newValue, changed)
    }

    @Test
    fun `find first`() {
        val sut = makeIntGrid()
        val expectedPoint = Point(4,0)
        val expectedValue = 5

        val results = sut.find(Item(5))

        assertEquals(expectedPoint, results.keys.first())
        assertEquals(expectedValue, results.values.first().value)
    }

    @Test
    fun `sum of each line`() {
        val sut = makeIntGrid()
        val expected = listOf(15, 20, 45)

        val sums = mutableListOf<Int>()
        val rows = sut.toRows()
        rows.map { row ->
            sums.add(row.reduce{ acc, item -> Item(acc.value + item.value) }.value)
        }

        assertEquals(expected, sums)
    }

    @Test
    fun `sum total`() {
        val sut = makeIntGrid()
        val expected = 80

        var sum = 0
        val rows = sut.toRows()
        rows.map { row->
            sum += row.reduce { acc, next -> Item(acc.value + next.value) }.value
        }

        assertEquals(expected, sum)
    }

    @Test
    fun `sum of each column`() {
        val sut = makeIntGrid()
        val expected = listOf(10, 13, 16, 19, 22)

        val sums = mutableListOf<Int>()
        val columns = sut.toColumns()
        columns.map { column->
            sums.add(column.reduce { acc, next -> Item(acc.value + next.value) }.value)
        }

        assertEquals(expected, sums)
    }


    /*
        Grid:
        1 2 3 4 5
        2 3 4 5 6
        7 8 9 10 11
     */
    private fun makeIntGrid(): Grid<Int> {
        val grid = Grid<Int>()
        val row1 = listOf(1,2,3,4,5).toItems()
        val row2 = listOf(2,3,4,5,6).toItems()
        val row3 = listOf(7,8,9,10,11).toItems()
        grid.addRow(row1)
        grid.addRow(row2)
        grid.addRow(row3)
        return grid
    }
}


