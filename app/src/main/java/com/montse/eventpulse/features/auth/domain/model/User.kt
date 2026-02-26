package com.montse.eventpulse.features.auth.domain.model

data class User(
    val id: String,
    val username: String,
    val name: String,
    val role: String, // "admin", "guardia", etc.
    val token: String
)