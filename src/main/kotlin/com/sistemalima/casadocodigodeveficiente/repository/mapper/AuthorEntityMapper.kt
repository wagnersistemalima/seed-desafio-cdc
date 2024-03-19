package com.sistemalima.casadocodigodeveficiente.repository.mapper

import com.sistemalima.casadocodigodeveficiente.controller.entity.AuthorResponse
import com.sistemalima.casadocodigodeveficiente.repository.entity.AuthorEntity

object AuthorEntityMapper {

    fun AuthorEntity.toResponse(): AuthorResponse {
        return AuthorResponse(
            id = this.id,
            name = this.name
        )
    }
}