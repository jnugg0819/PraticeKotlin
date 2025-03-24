package com.olio.gym.fit.algorithms

fun isAnagram(a: String, b: String): Boolean {

    if (a.length != b.length) return false

    var i = 0
    var j = 0
    val duplicateSet = mutableSetOf<Int>()

    while (j <= b.length - 1 && i <= a.length - 1) {// 마지막을 넘어갔다는건 더이상 찾을게 없다는뜻.
        if (a[i] == b[j] && !duplicateSet.contains(j)) {
            duplicateSet.add(j)
            j = 0
            i++
        } else {
            // 우리가 찾아야 할거는 안되는 조건만 찾으면 된다.
            // 끝까지 왔는데도 못찾았다면 false를 반환하면 된다. 필요없는 공간을 차지 할필요가 없다.
            if (j == b.length - 1) {
                return false
            }
            j++
        }
    }

    return true
}