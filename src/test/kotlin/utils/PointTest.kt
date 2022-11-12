package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PointTest {

    @Test
    fun `above `() {
        val expected = Point(0, 0)

        val actual = Point(0, 1).above()

        assertEquals(expected, actual)
    }

    @Test
    fun `below `() {
        val expected = Point(2, 3)

        val actual = Point(2, 2).below()

        assertEquals(expected, actual)
    }

    @Test
    fun `left `() {
        val expected = Point(9, 10)

        val actual = Point(10, 10).left()

        assertEquals(expected, actual)
    }

    @Test
    fun `right `() {
        val expected = Point(7, 5)

        val actual = Point(6, 5).right()

        assertEquals(expected, actual)
    }

    @Test
    fun `above left`() {
        val expected = Point(2, 7)

        val actual = Point(3, 8).above().left()

        assertEquals(expected, actual)
    }

    @Test
    fun `above right`() {
        val expected = Point(16, 5)

        val actual = Point(15, 6).above().right()

        assertEquals(expected, actual)
    }

    @Test
    fun `below left`() {
        val expected = Point(97, 4)

        val actual = Point(98, 3).below().left()

        assertEquals(expected, actual)
    }

    @Test
    fun `below right`() {
        val expected = Point(77, 66)

        val actual = Point(76, 65).below().right()

        assertEquals(expected, actual)
    }
}
