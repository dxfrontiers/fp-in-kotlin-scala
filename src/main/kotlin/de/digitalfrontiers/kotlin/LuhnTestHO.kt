package de.digitalfrontiers.kotlin

object LuhnTestHO {

    fun isValid(number: Long): Boolean {
        val factor = generateSequence(1) { 3 - it }.asIterable()
        val remainder = toDigits(number)
            .reversed()
            .zip(factor)
            .map { (digit, factor) -> factor * digit }
            .fold(0) { l, r -> l + r / 10 + r % 10 }

        return remainder % 10 == 0
    }

}

