package com.rpicturedictionary.rpd.api.dictionaryApi

data class DictionaryREsponseItem(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val word: String
)