package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ListExtKtTest {

    @Test
    fun sum() {
        val expected = 15
        val data = listOf(1, 2, 3, 4, 5).toItems()

        val actual = data.sum()

        assertEquals(expected, actual)
    }

    @Test
    fun `sum zero`() {
        val expected = 0
        val data = listOf(0).toItems()

        val actual = data.sum()

        assertEquals(expected, actual)
    }

    @Test
    fun `sum zero too`() {
        val expected = 0
        val data = listOf(1, -1).toItems()

        val actual = data.sum()

        assertEquals(expected, actual)
    }
}
