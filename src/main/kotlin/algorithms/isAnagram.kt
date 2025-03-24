package com.olio.gym.fit.algorithms


fun isAnagram(a: String, b: String): Boolean {

    if (a.length != b.length) return false

    val mapOfAChar = mutableMapOf<Char, Int>()
    val mapOfBChar = mutableMapOf<Char, Int>()

    for (char in a) {
        mapOfAChar[char] = (mapOfAChar[char] ?: 0) + 1
    }

    for(char in b) {
        mapOfBChar[char] = (mapOfBChar[char] ?: 0) + 1
    }

    // 시간 복잡도 O(N) 각 키를 조회하면서 키값을 비교해준다. 선형적으로 증가함.
    return mapOfAChar == mapOfBChar
}