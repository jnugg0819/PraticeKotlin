import com.olio.gym.fit.syntax.Identifier
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IdentifierTest {

    private val contacts = Identifier()

    @Test
    fun `The list of input names must contain exactly one item`() {
        assertEquals(1, contacts.getIdentifierCount("홍길동"))
    }
}