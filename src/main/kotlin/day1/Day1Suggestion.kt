package day1

fun main() {

    val sumList = list.map {
        it.sumOf { it.toInt() }
    }
    // region puzzle1
    println(sumList.max())
    // endregion

    // region puzzle2
    val result = sumList
        .sortedDescending()
        .subList(0, 3)
        .sum()
    println(result)
    // endregion
}
