package de.digitalfrontiers.kotlin

import de.digitalfrontiers.kotlin.LCPComposition.lcp

object LCPComposition {

    val lcp: (List<String>) -> String =
        ::findMinAndMaxElement
            .andThen(::combine)
            .andThen(::findCommonPrefix)
            .andThen(::extractCommonPrefix)
            .andThen(::mkString)

    fun findMinAndMaxElement(list: List<String>) =
        Pair(list.min() ?: "", list.max() ?: "")

    fun combine(pair: Pair<String, String>) =
        pair.first.zip(pair.second)

    fun findCommonPrefix(list: List<Pair<Char, Char>>) =
        list.takeWhile { (l, r) -> l == r }

    fun extractCommonPrefix(list: List<Pair<Char, Char>>) =
        list.unzip().first

    fun mkString(list: List<Char>) =
        list.joinToString(separator = "")
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
