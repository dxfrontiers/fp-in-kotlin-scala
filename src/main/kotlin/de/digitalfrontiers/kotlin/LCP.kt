package de.digitalfrontiers.kotlin

import de.digitalfrontiers.kotlin.LCPHigherOrder.lcp

object LCPHigherOrder {

    fun lcp(list: List<String>): String =
        (list.min() ?: "")
            .zip(list.max() ?: "")
            .takeWhile { (l, r) -> l == r }
            .unzip()
            .first
            .joinToString(separator = "")

}

fun main() {
    println(lcp(listOf("interspecies", "interstellar", "interstate")) == "inters")
    println(lcp(listOf("throne", "throne")) == "throne")
    println(lcp(listOf("throne", "dungeon")).isEmpty())
    println(lcp(listOf("cheese")) == "cheese")
    println(lcp(listOf("")).isEmpty())
    println(lcp(listOf()).isEmpty())
    println(lcp(listOf("prefix", "suffix")).isEmpty())
    println(lcp(listOf("foo", "foobar")) == "foo")
}
