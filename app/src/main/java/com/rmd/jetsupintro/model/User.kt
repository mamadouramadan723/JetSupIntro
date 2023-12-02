package com.rmd.jetsupintro.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = ""

)