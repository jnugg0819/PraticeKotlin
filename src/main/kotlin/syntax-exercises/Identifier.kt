class Identifier(private val namesAndIdentifiers: String) {

    val listOfIdentifiers: List<String> by lazy {
        namesAndIdentifiers.split(",").filter { it.isNotBlank() }
    }

    val namesList: List<String> by lazy {
        listOfIdentifiers.filterIndexed { index, value ->
            index % 2 == 0 && value.matches(Regex("^[가-힣a-zA-Z]+$"))
        }
    }

    val identifierList: List<String> by lazy {
        listOfIdentifiers.filterIndexed { index, value ->
            index % 2 == 1 && value.matches(Regex("^\\d{3,4}-\\d{3,4}$"))
        }
    }

    val mapIdentifiers: Map<String, Set<String>> by lazy {
        if (namesList.size != identifierList.size) {
            throw IllegalArgumentException("잘못된 데이터 형식: 이름과 식별자의 개수가 맞지 않습니다.")
        }

        namesList.zip(identifierList)
            .groupBy({ it.first }, { it.second })
            .mapValues { it.value.toSet() }
    }

    fun getIdentifiers(name: String): Set<String> {
        return mapIdentifiers[name] ?: emptySet()
    }

    fun getIdentifierCount(name: String): Int {
        return mapIdentifiers[name]?.size ?: 0
    }

    fun getAllNames(): List<String> {
        return namesList
    }
}
