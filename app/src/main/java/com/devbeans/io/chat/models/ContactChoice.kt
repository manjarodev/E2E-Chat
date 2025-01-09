package com.devbeans.io.chat.models

data class ContactChoice(
    val contactFromFile: Contact= Contact(),
    val fromDb: Boolean = false,
    val selected: Boolean = false,
    val contactFromDb: Contact=Contact()
)
