package br.com.digitalhouse.desafiodhandroidcore.domain

import java.io.Serializable

data class Restaurant(
    val name: String,
    var address: String,
    var closingHours: String,
    var photo: Int
): Serializable