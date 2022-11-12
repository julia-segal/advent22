package utils

fun List<Item<Int>>.sum(): Int =
    reduce { acc, item -> Item(acc.value + item.value) }.value
