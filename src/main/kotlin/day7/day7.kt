package day7

import utils.Input
import utils.Input.Day

class Day7 {

    data class Command(
        val command: String,
        val arg: String?
    )

    data class Node(
        val name: String,
        val isDir: Boolean,
        var size: Int,
        var children: MutableList<Node>,
        var parent: Node?
    ) {
        override fun toString(): String =
            if (isDir) "$name $size $children ${parent?.name ?: ""}"
            else "$name $size ${parent?.name ?: ""}"
    }

    private fun Node.child(name: String): Node {
        children.map {
            if (it.name == name) {
                return it
            }
        }
        return this
    }

    private fun Node.add(node: Node) {
        children.add(node)
    }

    private fun Node.totalSizes(): Int {
        size = children.sumOf { child ->
            if (child.isDir) {
                child.totalSizes()
            } else {
                child.size
            }
        }
        return size
    }

    // Sort by size
    private fun Node.toSortedList(map: MutableMap<String, Int>) {
        children.map { child ->
            if (child.isDir) {
                child.toSortedList(map)
            }
        }
        map[this.name] = this.size
    }

    private fun Node.atMost(max: Int): Int {
        var total = 0
        children.map { child ->
            if (child.isDir) {
                total += if (child.size <= max) {
                    (child.size + child.atMost(max))
                } else {
                    child.atMost(max)
                }
            }
        }
        return total
    }

    private val String.isCommand: Boolean
        get() = this == "$"

    private val String.isDir: Boolean
        get() = this.startsWith("dir")

    private val String.isFile: Boolean
        get() = this.first().isDigit()

    private fun List<String>.toCommand(): Command =
        if (this[1] == "cd") Command(this[1], this[2])
        else Command(this[1], null)

    private fun parse(lines: List<String>): Node {
        val root = Node("/", true, 0, mutableListOf(), null)
        var currentNode: Node = root
        var index = 0
        while (index < lines.lastIndex) {
            val line = lines[index].split(' ')
            if (line.first().isCommand) {
                val command = line.toCommand()
                when (command.command) {
                    "cd" -> {
                        currentNode = when (command.arg!!) {
                            "/" -> root
                            ".." -> currentNode.parent!!
                            else -> currentNode.child(command.arg)
                        }
                        index++
                    }

                    "ls" -> {
                        while (index < lines.lastIndex) {
                            index++
                            val file = lines[index].split(' ')
                            if (file.first().isDir) {
                                currentNode.add(
                                    Node(file.last(),
                                        true,
                                        0,
                                        mutableListOf(),
                                        currentNode)
                                )
                            } else if (file.first().isFile) {
                                currentNode.add(
                                    Node(
                                        file.last(),
                                        false,
                                        file.first().toInt(),
                                        mutableListOf(),
                                        currentNode
                                    )
                                )
                            } else {
                                break
                            }
                        }
                    }
                }
            }
        }
        return root
    }

    fun part2(lines: List<String>): Int {
        val FREE_NEEDED = 30000000
        val MAX = 70000000

        val tree = parse(lines)
        val unused = MAX - tree.totalSizes()
        val need = FREE_NEEDED - unused
        val sortedMap = mutableMapOf<String, Int>()
        tree.toSortedList(sortedMap)
        sortedMap.values.map { value ->
            if (value > need) {
                return value
            }
        }
        return 0
    }

    fun part1(lines: List<String>): Int {
        val tree = parse(lines)
        tree.totalSizes()
        return tree.atMost(100000)
    }
}

fun main() {
    val input = Input(Day.DAY7).getLines()

    println("Part 1: ${Day7().part1(input)}")
    println("Part 2: ${Day7().part2(input)}")
}
