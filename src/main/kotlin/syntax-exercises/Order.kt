package com.olio.gym.fit.`syntax-exercises`

class Order(
    private val orderSheet: String
) {

    private val orderList = orderSheet.split(";").filter { it.isNotBlank() }.onEach { model ->
        val specificOrder = model.split(",")
        require(specificOrder.size == 3) { "Invalid order format" }
    }

    // 가장 먼저 사용한곳에서 캐싱해주고 나중에 다시 사용하는곳에서 넣어줍니다.
    private val productPriceMap: Map<String, Int> by lazy {
        val productPrice = mutableMapOf<String, Int>()

        orderList.forEach { model ->
            val specificOrder = model.split(",")

            val increment = specificOrder[1].toInt() * specificOrder.last().toInt()
            productPrice[specificOrder.first()] = productPrice.getOrDefault(specificOrder.first(), 0) + increment
        }

        productPrice
    }

    fun getProductOrderList(): Set<String> = orderList.map { it.split(",").first() }.toSet()
    fun getProductOrderCount(): Int = orderList.size
    fun getPriceEachProduct(name: String): Int = productPriceMap[name] ?: 0
    fun getTotalPriceOfProducts(): Int = productPriceMap.values.sum()
}