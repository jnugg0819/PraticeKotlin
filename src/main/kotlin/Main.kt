package com.olio.gym.fit


fun main() {
    val numbers = listOf(6,2,8,4,16,14)
    println("Get Even Numbers ${getEvenNumbers(numbers)}")
}

fun getEvenNumbers(numbers: List<Int>): List<Int> {
    val newNumbers = numbers.filter { it % 2 == 0 }.toMutableList()

    for(i in 1 until newNumbers.size) {
        val current = newNumbers[i]
        var j = i - 1

        while (j >= 0 && newNumbers[j] > current) {
            newNumbers[j + 1] = newNumbers[j]
            j--
        }
        newNumbers[j + 1] = current
    }

    return newNumbers
}