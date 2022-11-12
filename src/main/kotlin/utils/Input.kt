package utils

import java.io.File
import java.util.*

private const val SRC_PATH = "src/main/kotlin/"
private const val INPUT_FILE_NAME = "/input.txt"

class Input(private val day: Day) {

    enum class Day {
        SAMPLE,
        DAY1,
        DAY2,
        DAY3,
        DAY4,
        DAY5,
        DAY6,
        DAY7,
        DAY8,
        DAY9,
        DAY10,
        DAY11,
        DAY12,
        DAY13,
        DAY14,
        DAY15,
        DAY16,
        DAY17,
        DAY18,
        DAY19,
        DAY20,
        DAY21,
        DAY22,
        DAY23,
        DAY24,
        DAY25
    }

    fun getLines(): List<String> = File("${SRC_PATH}${day.fileName}${INPUT_FILE_NAME}").readLines()

    private val Day.fileName
        get() = name.lowercase(Locale.getDefault())

    companion object {

        fun List<String>.items(separator: Char = ' '): List<String> {
            val items = mutableListOf<String>()
            map { line -> line.split(separator).map { item -> items.add(item) } }
            return items.filterNot { it == "" }
        }
    }
}
