package com.sistemalima.casadocodigodeveficiente.controller.mapper

import com.sistemalima.casadocodigodeveficiente.controller.entity.AuthorRequest
import com.sistemalima.casadocodigodeveficiente.repository.entity.AuthorEntity

object AuthorRequestMapper {

    fun AuthorRequest.toEntity(): AuthorEntity {
        return AuthorEntity(
            name = this.name,
            description = this.description,
            email = this.email
        )
    }
}