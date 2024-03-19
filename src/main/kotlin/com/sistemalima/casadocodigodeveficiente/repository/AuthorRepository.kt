package com.sistemalima.casadocodigodeveficiente.repository

import com.sistemalima.casadocodigodeveficiente.repository.entity.AuthorEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AuthorRepository: CrudRepository<AuthorEntity, Long> {

    fun findByEmail(email: String): Optional<AuthorEntity>
}