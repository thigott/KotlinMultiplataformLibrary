package com.thigott.kotlinmultiplataformlibrary.data.mappers.user

import com.thigott.kotlinmultiplataformlibrary.data.models.user.UserLoggedDataResponse
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import database.UserEntity

fun UserLoggedDataResponse.toDomain() = UserModel(
    customerId = customerId,
    userId = userId,
    cpf = cpf,
    username = userName,
    address = address,
    numberPhone = numberPhone,
    zipCode = zipcode,
    email = email
)

fun UserEntity.toDomain() = UserModel(
    customerId = 0,
    userId = id.toInt(),
    cpf = cpf,
    username = "",
    address = address,
    numberPhone = "",
    zipCode = "",
    email = ""
)