package com.olio.gym.fit.algorithms

fun isPalindrome(input: String): Boolean {
    var i = 0
    var j = input.length - 1

    // 두개의 포인터가 교차되는 시점부터는 더이상 비교할 필요없어진다.
    while (i < j) {
        if (input[i] == input[j]) {
            i++
            j--
        } else {
            return false
        }
    }

    return true
}