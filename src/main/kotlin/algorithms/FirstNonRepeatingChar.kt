package com.olio.gym.fit.algorithms

fun firstNonRepeatingChar(input: String): Char? {

    if(input.isEmpty()) return null

    val charMap = mutableMapOf<Char, Int>()

    for (char in input) {
        charMap[char] = (charMap[char] ?: 0) + 1
    }

    var resultChar : Char? = null

    for (entry in charMap) {
        if (entry.value == 1) {
            resultChar = entry.key
            break
        }
    }

    return resultChar
}