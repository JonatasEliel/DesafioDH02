package br.com.digitalhouse.desafiodhandroidcore.domain

import java.io.Serializable

data class Usuario(
    val id: Int,
    val name: String,
    var email: String,
    var password: Int
) : Serializable {
    override fun toString(): String {
        return "Usuário(Nome: $name - E-mail: $email - Senha: $password)"
    }
}