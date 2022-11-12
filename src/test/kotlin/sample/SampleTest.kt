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
            "16 2 3 X 9",
            "2 3 4 5 6",
            "8 8 8 8 X"
        )

        val expectedOutput = listOf(
            "17 3 X * X",
            "3 4 X X X",
            "9 9 9 X *"
        )

        val expected = Grid<String>()
        expected.addRow(expectedOutput[0].split(' ').toItems())
        expected.addRow(expectedOutput[1].split(' ').toItems())
        expected.addRow(expectedOutput[2].split(' ').toItems())

        val actual = sut.calculate(input)

        assertEquals(expected.toString(), actual.toString())
    }
}
