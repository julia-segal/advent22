package utils

fun Grid<Int>.sumRows(): List<Int> {
    val sums = mutableListOf<Int>()
    toRows().map { row -> sums.add(row.sum()) }
    return sums
}

fun Grid<Int>.sumColumns(): List<Int> {
    val sums = mutableListOf<Int>()
    toColumns().map { column -> sums.add(column.sum()) }
    return sums
}

fun Grid<Int>.sumTotal(): Int {
    var sum = 0
    toRows().map { row -> sum += row.sum() }
    return sum
}
