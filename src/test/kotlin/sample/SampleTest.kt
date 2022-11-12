package sample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.Grid
import utils.toItems

internal class SampleTest {

    private val sut = Sample()

    @Test
    fun test() {
        val input = listOf(
            "1 2 3 X 9",
            "2 3 4 5 6",
            "8 8 8 8 X"
        )

        val expected = Grid<String>()
        expected.addRow("1 2 X X X".split(' ').toItems())
        expected.addRow("2 3 X X X".split(' ').toItems())
        expected.addRow("8 8 8 X X".split(' ').toItems())

        val actual = sut.calculate(input)

        assertEquals(expected.toString(), actual.toString())
    }

}