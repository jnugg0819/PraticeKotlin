import com.olio.gym.fit.`syntax-exercises`.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class OrderTest {

    private val orderSheet = "노트북,1500000,2;마우스,25000,3;키보드,75000,1;노트북,1500000,1"
    private val order = Order(orderSheet)

    @Test
    fun `중복을 허용하지 않은 상품 목록을 가지고 온다`() {

        val productList = order.getProductOrderList()

        println("✅ TEST START: Checking '주문 목록 리스트'")
        println(" - Expected : [노트북, 마우스, 키보드] Actual: $productList")

        assertEquals(setOf("노트북", "마우스", "키보드"), productList)
    }

    @Test
    fun `상품의 수량을 합산하여 저장한다 단 중복은 허용한다`() {

        val productCount = order.getProductOrderCount()

        println("✅ TEST START: Checking '주문 상품 개수'")
        println(" - Expected : 4 Actual: $productCount")

        assertEquals(4, productCount)
    }

    @Test
    fun `노트북 상품의 총가격은 450만원이다`() {

        val priceOfProduct = order.getPriceEachProduct("노트북")

        println("✅ TEST START: Checking '노트북 상품 가격'")
        println(" - Expected : 4500000 Actual: $priceOfProduct")

        assertEquals(4500000, priceOfProduct)
    }

    @Test
    fun `총 주문 계산 금액은 465만원이다`() {
        val totalPrice = order.getTotalPriceOfProducts()

        println("✅ TEST START: Checking '총 상품의 가격'")
        println(" - Expected : 4600000 Actual: $totalPrice")

        assertEquals(4650000, totalPrice)
    }

    @Test
    fun `잘못된 형식의 주문양식 포맷이 들어가면 예외를 던진다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Order(" 노트북,1500000;마우스,25000,3;키보드,75000,1;노트북,1500000,1")
        }

        println("✅ TEST START: 잘못된 주문 양식")
        assertEquals("Invalid order format", exception.message)
    }

}