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
    )

    private fun Node.hasChild(name: String): Boolean {
        children.map { if (it.name == name) { return true } }
        return false
    }

    fun Node.child(name: String): Node {
        children.map { if (it.name == name) { return it } }
        return this
    }

    fun Node.add(node: Node) {
        children.add(node)
    }

    fun Node.totalSizes(): Int {
        size = children.map { child ->
            if (child.isDir) {
                child.totalSizes()
            } else {
                child.size
            }
        }.sum()
        return size
    }

    // Sort by size
    fun Node.sorted(map: MutableMap<String, Int>) {
        children.map { child ->
            if (child.isDir) {
                child.sorted(map)
            }
        }
        map[this.name] = this.size
    }

    fun Node.atMost(max: Int): Int {
        var total = 0
        children.map { child ->
            if (child.isDir) {
                if (child.size <= max) {
                    total += (child.size + child.atMost(max))
                } else {
                    total += child.atMost(max)
                }
            }
        }
        return total
    }

    val String.isCommand: Boolean
        get() = this == "$"

    val String.isDir: Boolean
        get() = this.startsWith("dir")

    val String.isFile: Boolean
        get() = this.first().isDigit()

    val String.listing: Boolean
        get() = this[0].isDigit()

    fun List<String>.toCommand(): Command =
        if (this[1] == "cd") Command(this[1], this[2])
        else Command(this[1], null)

    fun parse(lines: List<String>): Node {
        val root = Node("/", true, 0, mutableListOf(), null)
        var currentNode: Node = root
        var curIndex = 0
        while (curIndex < lines.lastIndex) {
            val line = lines[curIndex].split(' ')
            if (line.first().isCommand) {
                val command = line.toCommand()
                when (command.command) {
                    "cd" -> {
                        val arg = command.arg!!
                        when (arg) {
                            "/" -> currentNode = root
                            ".." -> currentNode = currentNode.parent!!
                            else -> {
                                if (currentNode.hasChild(command.arg)) {
                                    currentNode = currentNode.child(command.arg)
                                }
                            }
                        }
                        curIndex++
                    }

                    "ls" -> {
                        while (curIndex < lines.lastIndex) {
                            curIndex++
                            val l = lines[curIndex].split(' ')
                            if (l.first().isDir) {
                                if (currentNode?.hasChild(l.last()) == false) {
                                    val newNode = Node(l.last(), true, 0, mutableListOf<Node>(), currentNode)
                                    currentNode.add(newNode)
                                }
                            } else if (l.first().isFile) {
                                if (currentNode?.hasChild(l.last()) == false) {
                                    val newNode =
                                        Node(l.last(), false, l.first().toInt(), mutableListOf<Node>(), currentNode)
                                    currentNode.add(newNode)
                                }
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
        tree.sorted(sortedMap)
        val values = sortedMap.values.sorted()
        values.map { value ->
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
