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

fun isPalindromeForInteger(x: Int): Boolean {

    if (x < 0) {
        return false // 음수일때는 앞뒤가 같을 수가 없다.
    }

    var quotient = x / 10
    var remainder = x % 10


    val remainderList = ArrayList<Int>()
    remainderList.add(remainder)

    // 10으로 나눈 몫과, 나머지를 계산하여 리스트에 넣어준다. 그러면 각 자릿수에대한 숫자를 구할 수 있다.
    while (quotient != 0) {
        remainder = quotient % 10
        quotient /= 10
        remainderList.add(remainder)
    }

    var i = 0
    var j = remainderList.size - 1

    while (i < j) {
        if (remainderList[i] == remainderList[j]) {
            i++
            j--
        } else {
            return false
        }
    }

    return true
}