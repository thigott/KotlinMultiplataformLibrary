package com.thigott.kotlinmultiplataformlibrary.domain.models

data class UserModel(
    val customerId: Int,
    val userId: Int,
    val cpf: String,
    val username: String,
    val address: String,
    val numberPhone: String,
    val zipCode: String,
    val email: String
)
