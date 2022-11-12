package utils

data class Item<T>(val value: T) {

    override fun toString(): String = value.toString()
}

fun List<String>.toItems(separator: Char = ' '): List<Item<String>> {
    val items = mutableListOf<Item<String>>()
    map { line -> line.split(separator).map { item ->items.add(Item(item)) } }
    return items
}

fun List<Int>.toItems(): List<Item<Int>> = map { Item( it) }

fun List<String>.toStringItems(): List<Item<String>> = map { Item( it) }