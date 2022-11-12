package utils

data class Point(val x: Int, val y: Int)

fun Point.above(step: Int = 1): Point = Point(x, y - step)
fun Point.below(step: Int = 1): Point = Point(x, y + step)
fun Point.left(step: Int = 1): Point = Point(x - step, y)
fun Point.right(step: Int = 1): Point = Point(x + step, y)
