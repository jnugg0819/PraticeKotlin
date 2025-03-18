package com.olio.gym.fit.syntax

class Identifier {

    private val namesAndIdentifiers = "홍길동,1234-5678,이순신,8765-4321,홍길동,1234-5678,아이유,3333-4444"

    private val listOfIdentifiers: List<String> by lazy {
        // , 형식이 깨진경우를 대비.
        namesAndIdentifiers.split(",").filter { it.isNotBlank() }
    }

    private val namesList: List<String> by lazy {
        listOfIdentifiers.filterIndexed { index, _ -> index % 2 == 0 }
    }

    private val identifierList: List<String> by lazy {
        listOfIdentifiers.filterIndexed { index, _ -> index % 2 == 1 }
    }

    private val mapIdentifiers: Map<String, Set<String>> by lazy {

        // 두개의 리스트가 사이즈가 맞지않으면 예외를 던짐.
        if (namesList.size != identifierList.size) {
            throw IllegalArgumentException("잘못된 데이터 형식: 이름과 식별자의 개수가 맞지 않습니다.")
        }

        namesList.zip(identifierList)
            .groupBy({ it.first }, { it.second })
            .mapValues { it.value.toSet() }
    }

    fun getIdentifierCount(name: String): Int {
        return mapIdentifiers[name]?.size ?: 0
    }

    fun getAllNames(): List<String> {
        return namesList
    }
}