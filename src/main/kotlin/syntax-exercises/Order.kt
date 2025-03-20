package com.olio.gym.fit.`syntax-exercises`

class Order(
    private val orderSheet: String
) {

    private val orderList = orderSheet.split(";").filter { it.isNotBlank() }.onEach { model ->
        val specificOrder = model.split(",")
        require(specificOrder.size == 3)
    }

    fun getProductOrderList(): MutableSet<String> {
        // 중복된 상품 목록은 허용 안한다 혹시모르니까 순서 유지.
        val productOrderList = mutableSetOf<String>()

        orderList.forEach { model ->
            val specificOrder = model.split(",")
            productOrderList.add(specificOrder[0])
        }

        return productOrderList
    }

    fun getProductOrderCount(): Int {
        val productOrderList = mutableListOf<String>()

        orderList.forEach { model ->
            val specificOrder = model.split(",")
            productOrderList.add(specificOrder[0])
        }

        return productOrderList.size
    }

    private fun getMapOfProductPrice(): MutableMap<String, Int> {
        val productPrice = mutableMapOf<String, Int>()

        orderList.forEach { model ->
            val specificOrder = model.split(",")

            val increment = specificOrder[1].toInt() * specificOrder.last().toInt()

            if (productPrice.containsKey(specificOrder.first())) {
                val value = productPrice[specificOrder.first()]
                productPrice[specificOrder.first()] = (value ?: 0) + increment
            } else {
                productPrice[specificOrder.first()] = increment
            }
        }

        return productPrice
    }

    fun getPriceEachProduct(name: String): Int {
        val productPrice = getMapOfProductPrice()
        return productPrice[name] ?: 0
    }

    fun getTotalPriceOfProducts(): Int {
        val productPrice = getMapOfProductPrice()
        return productPrice.values.sum()
    }
}