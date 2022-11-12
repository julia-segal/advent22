package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InputTest {

    private val sut = Input(Input.Day.DAY1)

    @Test
    fun `lines from file`() {
        val expected = listOf("hi how are you","I am fine")

        val result = sut.getLines()

        assertEquals(expected, result)
    }
}