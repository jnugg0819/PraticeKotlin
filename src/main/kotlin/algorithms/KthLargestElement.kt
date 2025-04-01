package com.olio.gym.fit.algorithms

import java.util.PriorityQueue

fun findKthLargest(numbs: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Int>(compareByDescending{it})

    for(num in numbs) {
        maxHeap.add(num)
    }

    repeat(k - 1) {
        maxHeap.poll()
    }

    return maxHeap.poll()
}