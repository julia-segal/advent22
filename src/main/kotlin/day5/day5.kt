package day5

import utils.Input
import utils.Input.Day

class Day5 {
    data class Instruction(val count: Int, val from: Int, val to: Int)

    private fun String.toInstruction(): Instruction {
        val command = split(' ')
        return Instruction(count = command[1].toInt(), from = command[3].toInt(), to = command[5].toInt())
    }

    private fun String.toStacks(stacks: HashMap<Int, MutableList<Char>>) {
        var stackNumber = 1
        var lineIndex = 1
        while (lineIndex < this.length) {
            val item = this[lineIndex]
            if (!item.isWhitespace()) {
                stacks[stackNumber]?.add(this[lineIndex])
                    ?: run { stacks.put(stackNumber, mutableListOf(this[lineIndex])) }
            }
            lineIndex += 4
            stackNumber++
        }
    }

    private fun parse(lines: List<String>): Pair<HashMap<Int, MutableList<Char>>, List<Instruction>> {
        val stacks = hashMapOf<Int, MutableList<Char>>()
        val instructions = mutableListOf<Instruction>()

        lines.map {
            when {
                it.startsWith("move") -> instructions.add(it.toInstruction())
                it.startsWith(" 1 ") -> {}
                it.startsWith("\n") -> {}
                else -> it.toStacks(stacks)
            }
        }
        stacks.forEach { (_, stackOfChars) -> stackOfChars.reverse() }
        return Pair(stacks, instructions)
    }

    private fun moveIt(stacks: HashMap<Int, MutableList<Char>>, instructions: List<Instruction>): String {
        instructions.map { instruction ->
            repeat(instruction.count) {
                stacks[instruction.to]?.add(stacks[instruction.from]!!.last())
                stacks[instruction.from]?.removeLast()
            }
        }
        return stacks.keys.map { stacks[it]?.last() }.joinToString("")
    }

    private fun moveIt2(stacks: HashMap<Int, MutableList<Char>>, instructions: List<Instruction>): String {
        instructions.map { instruction ->
            for (i in instruction.count - 1 downTo 0) {
                val fromIndex = stacks[instruction.from]!!.lastIndex - i
                stacks[instruction.to]?.add(stacks[instruction.from]!![fromIndex])
                stacks[instruction.from]?.removeAt(fromIndex)
            }
        }
        return stacks.keys.map { stacks[it]?.last() }.joinToString("")
    }

    fun part2(lines: List<String>): String {
        val (stacks, instructions) = parse(lines)
        return moveIt2(stacks, instructions)
    }

    fun part1(lines: List<String>): String {
        val (stacks, instructions) = parse(lines)
        return moveIt(stacks, instructions)
    }
}

fun main() {
    val input = Input(Day.DAY5).getLines()

    println("Part 1: ${Day5().part1(input)}")
    println("Part 2: ${Day5().part2(input)}")
}
