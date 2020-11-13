package br.com.digitalhouse.desafiodhandroidcore.domain

import java.io.Serializable

data class Usuario(
    val id: Int,
    val nome: String,
    var email: String,
    var password: Int
) : Serializable {
    override fun toString(): String {
        return "Usuário(Nome: $nome - E-mail: $email - Senha: $password)"
    }
}