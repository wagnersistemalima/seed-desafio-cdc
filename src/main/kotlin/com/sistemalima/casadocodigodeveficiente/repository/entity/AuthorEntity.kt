package com.sistemalima.casadocodigodeveficiente.repository.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime

@Entity
@Table(name = "tb_author")
data class AuthorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    @field:Length(max = 400)
    val description: String,

    @field:Email
    @field:NotBlank
    val email: String,

    @field:NotNull
    val createAt: LocalDateTime = LocalDateTime.now()
)
