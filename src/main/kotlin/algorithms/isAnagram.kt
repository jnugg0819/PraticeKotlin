package com.olio.gym.fit.algorithms


fun isAnagram(a: String, b: String): Boolean {

    val mapOfChar = mutableMapOf<Char, Int>()

    for (char in a) {
        mapOfChar[char] = (mapOfChar[char] ?: 0) + 1
    }

    // 기존 맵에서 뺴주는 방식으로 변경.
    for (char in b) {
        val count = mapOfChar[char]
        if (count == null || count == 0) {
            return false
        }
        mapOfChar[char] = count - 1
    }

    return mapOfChar.all { it.value == 0 }
}