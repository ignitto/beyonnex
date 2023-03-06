package io.beyonnex.ignas

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AnagramServiceTest {

    private lateinit var anagramService: AnagramService

    @BeforeEach
    fun init() {
        anagramService = AnagramService()
    }

    @ParameterizedTest
    @CsvSource(
        "restful, fluster",
        "cheater, teacher",
        "santa, satan"
    )
    fun `should return true for single word`(text1: String, text2: String) {
        assertTrue(anagramService.isAnagram(text1, text2))
    }

    @ParameterizedTest
    @CsvSource(
        "forty five, over fifty",
        "a gentleman, elegant man",
        "eleven plus two, twelve plus one"
    )
    fun `should return true for text anagrams`(text1: String, text2: String) {
        assertTrue(anagramService.isAnagram(text1, text2))
    }

    @ParameterizedTest
    @CsvSource(
        "New York Times, monkeys write",
        "Madam Curie, Radium came",
        "William Shakespeare, I am a weakish speller"
    )
    fun `should return true for capital case text anagrams`(text1: String, text2: String) {
        assertTrue(anagramService.isAnagram(text1, text2))
    }

    @Test
    fun `should return true with special chars`() {
        assertTrue(anagramService.isAnagram("Lorin Morgan-Richards", "Marcil d'Hirson Garron"))
    }

    @ParameterizedTest
    @CsvSource(
        "One, Two",
        "get, post",
        "today cloudy,  today sunny"
    )
    fun `should return false for non anagrams`(text1: String, text2: String) {
        assertFalse(anagramService.isAnagram(text1, text2))
    }

    @Test
    fun `should return true for empty texts`() {
        assertTrue(anagramService.isAnagram("", ""))
        assertTrue(anagramService.isAnagram("   ", ""))
    }
}