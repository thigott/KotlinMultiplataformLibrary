package com.thigott.kotlinmultiplataformlibrary.data.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserLoggedDataResponse(
    @SerialName("idPessoa")
    val customerId: Int,
    @SerialName("idUsuario")
    val userId: Int,
    @SerialName("cpf")
    val cpf: String,
    @SerialName("nome")
    val userName: String,
    @SerialName("endereco")
    val address: String,
    @SerialName("celularNumero")
    val numberPhone: String,
    @SerialName("cep")
    val zipcode: String,
    @SerialName("email")
    val email: String
)