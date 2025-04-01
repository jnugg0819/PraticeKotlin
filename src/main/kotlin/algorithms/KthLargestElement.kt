package com.olio.gym.fit.algorithms

import java.util.PriorityQueue

fun findKthLargest(numbs: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Int>(compareByDescending{it})

    for(num in numbs) {
        maxHeap.add(num)
    }

    var resultK = 0

    while (maxHeap.isNotEmpty()) {
        val value = maxHeap.poll()
        resultK++
        if(value == k) {
            return resultK
        }
    }

    return resultK
}