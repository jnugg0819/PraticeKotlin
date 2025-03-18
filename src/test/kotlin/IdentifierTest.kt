import com.olio.gym.fit.syntax.Identifier
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IdentifierTest {

    private val contacts = Identifier()

    @Test
    fun `The list of input names must contain exactly one item`() {
        val count = contacts.getIdentifierCount("홍길동")
        val firstElement = contacts.getAllNames()[0]

        println("✅ TEST START: Checking '홍길동'")
        println(" - Expected Count: 1, Actual: $count")
        println(" - Expected First Element: 홍길동, Actual: $firstElement")

        assertEquals(1, count)
        assertEquals("홍길동", firstElement)
        println("✅ TEST PASSED: The list of input names contains exactly one item")
    }

}