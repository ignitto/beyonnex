package io.beyonnex.ignas

import org.springframework.stereotype.Service

@Service
class AnagramService {

    fun isAnagram(input1: String, input2: String): Boolean {
        val word1 = stringToSortedCharArray(input1)
        val word2 = stringToSortedCharArray(input2)
        return word1.contentEquals(word2)
    }

    private fun stringToSortedCharArray(input: String): CharArray {
        return input.replace("[^a-zA-Z]+".toRegex(), "")
            .lowercase()
            .toCharArray()
            .sortedArray()
    }

}