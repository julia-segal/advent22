package utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GridExtTest {

    @Test
    fun `sum of each row`() {
        val sut = makeIntGrid()
        val expected = listOf(15, 20, 45)

        val actual = sut.sumRows()

        assertEquals(expected, actual)
    }

    @Test
    fun `sum of each column`() {
        val sut = makeIntGrid()
        val expected = listOf(10, 13, 16, 19, 22)

        val actual = sut.sumColumns()

        assertEquals(expected, actual)
    }

    @Test
    fun `sum total`() {
        val sut = makeIntGrid()
        val expected = 80

        val actual = sut.sumTotal()

        assertEquals(expected, actual)
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
