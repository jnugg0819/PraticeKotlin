
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IdentifierTest {

    private val identifier = Identifier("홍길동,,1234-5678,이순신,8765-4321,,홍길동,9999-8888,아이유,3333-4444")

    @Test
    fun `The list of input names must contain exactly one item`() {
        val count = identifier.getIdentifierCount("홍길동")
        val firstElement = identifier.getAllNames()[0]

        println("✅ TEST START: Checking '홍길동'")
        println(" - Expected Count: 1, Actual: $count")
        println(" - Expected First Element: 홍길동, Actual: $firstElement")

        assertEquals(1, count)
        assertEquals("홍길동", firstElement)
        println("✅ TEST PASSED: The list of input names contains exactly one item")
    }


    @Test
    fun `이름을 검색했을때 여러개의 식별자를 가지고 올 수 있다`() {
        val nameOfIdentifiersCount = identifier.getIdentifierCount("홍길동")
        val nameOfIdentifiers = identifier.getIdentifiers("홍길동")

        println("✅ TEST START: 홍길동의 식별자 가져오기")
        println(" - Expected Count: 2, Actual: $nameOfIdentifiersCount")
        println(" - Expected Identifiers: [1234-5678, 9999-8888], Actual: $nameOfIdentifiers")

        assertEquals(2, nameOfIdentifiersCount)
        assertEquals(setOf("1234-5678", "9999-8888"), nameOfIdentifiers)

    }

    @Test
    fun `이순신을 검색했을때 오직 하나의 식별자만 있어야한다`() {
        val leeSunShin = identifier.getIdentifierCount("이순신")

        println("✅ TEST START: 이순신의 식별자 가져오기")
        println(" - Expected Count: 1, Actual: $leeSunShin")

        assertEquals(1, leeSunShin)
    }

    @Test
    fun `없는데이터를 조회하면 0이 반환되어야 한다`() {
        val targetValue = identifier.getIdentifierCount("김두환")
        val targetIdentifiers = identifier.getIdentifiers("김두환")

        println("✅ TEST START: 없는 식별자 테스트")
        println(" - Expected Count: 0, Actual: $targetValue")

        assertEquals(0, targetValue)
        assertTrue(targetIdentifiers.isEmpty())
    }

    @Test
    fun `짝이 맞지 않는 데이터가 있으면 예외가 발생해야 한다`() {
        val exception = kotlin.runCatching {
            Identifier("홍길동,1234-5678,이순신,8765-4321,홍길동").apply {  // "홍길동"이 짝이 맞지 않음
                getIdentifierCount("홍길동")
            }
        }.exceptionOrNull()
        println("✅ TEST START: 짝이 안 맞는 데이터 예외 발생 확인")
        println(" - Expected Exception: IllegalArgumentException, Actual: ${exception?.javaClass?.simpleName}")

        assertTrue(exception is IllegalArgumentException)
    }

    @Test
    fun `잘못된 split 형식이 있어도 각 이름에 대해서 올바른 식별자만 가져야 한다`() {

        val hongIden = identifier.getIdentifiers("홍길동")
        val iUIDen = identifier.getIdentifiers("아이유")

        println("✅ TEST START: 홍길동 & 아이유 식별자 테스트")
        println(" - Expected value for 홍길동: [1234-5678, 9999-8888], Actual: $hongIden")
        println(" - Expected value for 아이유: [3333-4444], Actual: $iUIDen")

        assertEquals(setOf("1234-5678", "9999-8888"), hongIden.toSet())
        assertEquals(setOf("3333-4444"), iUIDen.toSet())
    }

    @Test
    fun `잘못된 데이터가 있어도 정상적으로 파싱해야 한다`() {
        val corruptedData = "홍길동,,1234-5678,이순신,8765-4321,,아이유,3333-4444"
        val corruptedIdentifier = Identifier(corruptedData)

        val hongIden = corruptedIdentifier.getIdentifiers("홍길동")
        val leeIden = corruptedIdentifier.getIdentifiers("이순신")
        val iuIden = corruptedIdentifier.getIdentifiers("아이유")

        println("✅ TEST START: 데이터 형식이 깨졌을 때 정상 작동하는지 테스트")
        println(" - Expected value for 홍길동: [1234-5678], Actual: $hongIden")
        println(" - Expected value for 이순신: [8765-4321], Actual: $leeIden")
        println(" - Expected value for 아이유: [3333-4444], Actual: $iuIden")

        assertEquals(setOf("1234-5678"), hongIden.toSet())
        assertEquals(setOf("8765-4321"), leeIden.toSet())
        assertEquals(setOf("3333-4444"), iuIden.toSet())
    }

    @Test
    fun `잘못된 형식으로 이름만 들어왔을 때 예외가 발생하지 않고 빈 리스트를 반환해야 한다`() {
        val corruptedData = "홍길동,,이순신"
        val corruptedIdentifier = Identifier(corruptedData)

        val hongIden = corruptedIdentifier.getIdentifiers("홍길동")
        val leeIden = corruptedIdentifier.getIdentifiers("이순신")

        println("✅ TEST START: 잘못된 데이터 형식 (이름만 있음) 테스트")
        println(" - Expected value for 홍길동: [], Actual: $hongIden")
        println(" - Expected value for 이순신: [], Actual: $leeIden")

        assertTrue(hongIden.isEmpty())
        assertTrue(leeIden.isEmpty())
    }

}