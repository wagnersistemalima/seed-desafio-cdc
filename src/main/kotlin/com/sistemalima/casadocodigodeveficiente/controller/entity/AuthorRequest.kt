package com.sistemalima.casadocodigodeveficiente.controller.entity

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length


data class AuthorRequest(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    @field:Length(max = 400)
    val description: String,

    @field:Email
    @field:NotBlank
    val email: String
)
