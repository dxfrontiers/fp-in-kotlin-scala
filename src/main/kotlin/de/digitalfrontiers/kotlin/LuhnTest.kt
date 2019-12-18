package de.digitalfrontiers.kotlin

val isValid: (Long) -> Boolean =
    ::toDigits
        .andThen(::reverse)
        .andThen(::double2nd)
        .andThen(::sumDigits)
        .andThen(::divBy10)

fun toDigits(number: Long): List<Int> {
    val l = mutableListOf<Int>()
    var num = number

    while (num > 0) {
        l.add((num % 10).toInt())
        num /= 10
    }

    return l.toList()
}

fun reverse(l: List<Int>): List<Int> = l.reversed()

fun double2nd(l: List<Int>): List<Int> {
    return l.withIndex().map { (index, value) -> value * (index % 2 + 1) }
}

fun sumDigits(l: List<Int>): Int {
    return l.flatMap { toDigits(it.toLong()) }.sum()
}

fun divBy10(n: Int): Boolean = n % 10 == 0

infix fun<V, T, R> Function1<V, T>.andThen(after: (T) -> R): (V) -> R {
    return { v: V -> after(this(v)) }
}
