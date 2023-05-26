package com.thigott.kotlinmultiplataformlibrary.data.mappers.user

import com.thigott.kotlinmultiplataformlibrary.data.models.user.UserLoggedDataResponse
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel

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