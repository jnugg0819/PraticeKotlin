package com.olio.gym.fit.algorithms

fun firstNonRepeatingChar(input: String): Char? {

    val storedCharMap = mutableMapOf<Int, CharacterCount>()
    var countForIndex = 0

    for (i in input.indices) {

        val index = storedCharMap.values.indexOfFirst { it.character == input[i] }

        if (index != -1) {
            storedCharMap[index]!!.count += 1
        } else {
            storedCharMap[countForIndex] = CharacterCount(input[i], 1)
            countForIndex++
        }
    }

    val filteredList = storedCharMap.filter { it.value.count <= 1 }.toMap()

    return if (filteredList.isEmpty()) {
        null
    } else {
        filteredList.entries.first().value.character
    }
}

data class CharacterCount(val character: Char, var count: Int = 1)