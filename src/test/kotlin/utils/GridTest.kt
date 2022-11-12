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

        assertEquals(expected, sut.toRows())
    }

    @Test
    fun `add row of numbers`() {
        val expected =
            listOf(
                listOf(1, 2, 3, 4, 5).toItems(),
                listOf(2, 3, 4, 5, 6).toItems(),
                listOf(7, 8, 9, 10, 11).toItems()
            )

        val sut = makeIntGrid()

        assertEquals(expected, sut.toRows())
    }

    @Test
    fun `get dimens`() {
        val expectedXDimen = 5
        val expectedYDimen = 3
        val sut = makeIntGrid()

        val actual = sut.dimens

        assertEquals(expectedXDimen, actual.first)
        assertEquals(expectedYDimen, actual.second)
    }

    @Test
    fun `get above`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 1).above())!!.value

        assertEquals(3, result)
    }

    @Test
    fun `get above left`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 2).above().left())!!.value

        assertEquals(3, result)
    }

    @Test
    fun `get above right`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 2).above().right())!!.value

        assertEquals(5, result)
    }

    @Test
    fun `get below left`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(1, 1).below().left())!!.value

        assertEquals(7, result)
    }

    @Test
    fun `get below right`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(1, 1).below().right())!!.value

        assertEquals(9, result)
    }


    @Test
    fun `get above is null`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 0).above())

        assertNull(result)
    }

    @Test
    fun `get below`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 1).below())!!.value

        assertEquals(9, result)
    }

    @Test
    fun `get below is null`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 2).below())

        assertNull(result)
    }

    @Test
    fun `get left`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 1).left())!!.value

        assertEquals(3, result)
    }

    @Test
    fun `get left is null`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(0, 2).left())

        assertNull(result)
    }

    @Test
    fun `get right`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(2, 1).right())!!.value

        assertEquals(5, result)
    }

    @Test
    fun `get right is null`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(0, 5).right())

        assertNull(result)
    }

    @Test
    fun `get item at`() {
        val sut = makeIntGrid()

        val result = sut.itemAt(Point(3, 2))!!.value

        assertEquals(10, result)
    }

    @Test
    fun `change item at`() {
        val sut = makeIntGrid()
        val oldValue = 10
        val newValue = -2

        val original = sut.itemAt(Point(3, 2))!!.value
        sut.putItemAt(Point(3, 2), Item(newValue))
        val changed = sut.itemAt(Point(3, 2))!!.value

        assertEquals(oldValue, original)
        assertEquals(newValue, changed)
    }

    @Test
    fun `find first`() {
        val sut = makeIntGrid()
        val expectedPoint = Point(4, 0)
        val expectedValue = 5

        val results = sut.findItem(Item(5))

        assertEquals(expectedPoint, results.keys.first())
        assertEquals(expectedValue, results.values.first().value)
    }

    @Test
    fun `for each multiply by 3, add 2`() {
        val sut = makeIntGrid()
        val expected =
            listOf(
                listOf(5, 8, 11, 14, 17).toItems(),
                listOf(8, 11, 14, 17, 20).toItems(),
                listOf(23, 26, 29, 32, 35).toItems()
            )


        sut.forEach { (it * 3) + 2 }

        assertEquals(expected, sut.toRows())
    }

    @Test
    fun `make all items 0`() {
        val sut = makeIntGrid()
        val expected =
            listOf(
                listOf(0, 0, 0, 0, 0).toItems(),
                listOf(0, 0, 0, 0, 0).toItems(),
                listOf(0, 0, 0, 0, 0).toItems()
            )


        sut.forEach { 0 }

        assertEquals(expected, sut.toRows())
    }

    /*
        Grid:
        1 2 3 4 5
        2 3 4 5 6
        7 8 9 10 11
     */
    private fun makeIntGrid(): Grid<Int> {
        val grid = Grid<Int>()
        val row1 = listOf(1, 2, 3, 4, 5).toItems()
        val row2 = listOf(2, 3, 4, 5, 6).toItems()
        val row3 = listOf(7, 8, 9, 10, 11).toItems()
        grid.addRow(row1)
        grid.addRow(row2)
        grid.addRow(row3)
        return grid
    }
}
