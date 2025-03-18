package com.olio.gym.fit.syntax

class Identifier {

    private val namesAndIdentifiers = "홍길동,1234-5678,이순신,8765-4321,홍길동,1234-5678,아이유,3333-4444"

    fun getIdentifierCount(name: String): Int {

        val listOfIdentifiers = namesAndIdentifiers.split(",")

        val mapIdentifiers = mutableMapOf<String, MutableList<String>>()

        val namesList = listOfIdentifiers.filterIndexed { index, _ -> index % 2 == 0 }
        val identifierList = listOfIdentifiers.filterIndexed { index, _ -> index % 2 == 1 }

        namesList.forEachIndexed { index, s ->
//              1. 첫번째 내가 생각하던 구상.
//            val valueList: MutableList<String>
//
//            if(mapIdentifiers[s].isNullOrEmpty()) {
//                valueList = mutableListOf()
//                valueList.add(identifierList[index])
//                mapIdentifiers[s] = valueList
//            } else {
//                mapIdentifiers[s]?.add(identifierList[index])
//            }

            // 2. 업그레이드된 구상.
//            val valueList = mapIdentifiers[s] ?: mutableListOf<String>().also { mapIdentifiers[s] = it }
//            valueList.add(identifierList[index])


            // 3. 최종적으로 찾아본 최적 구상.
            mapIdentifiers.computeIfAbsent(s) { mutableListOf() }.add(identifierList[index])
        }

        println("${mapIdentifiers[name]?.size} ${mapIdentifiers} ${mapIdentifiers[name]?.distinct()}")

        return mapIdentifiers[name]?.distinct()?.size ?: 0
    }
}