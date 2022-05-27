package com.rpicturedictionary.rpd.api.dictionaryApi

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)