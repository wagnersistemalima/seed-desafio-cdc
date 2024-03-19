package com.sistemalima.casadocodigodeveficiente.controller

import com.sistemalima.casadocodigodeveficiente.controller.entity.AuthorRequest
import com.sistemalima.casadocodigodeveficiente.controller.entity.AuthorResponse
import com.sistemalima.casadocodigodeveficiente.controller.mapper.AuthorRequestMapper.toEntity
import jakarta.persistence.EntityManager
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE], path = ["/autores"])
class AuthorController(
    private val entityManager: EntityManager
) {

    @PostMapping
    @Transactional
    fun create(
        @Valid @RequestBody authorRequest: AuthorRequest
    ): ResponseEntity<Any> {
        entityManager.persist(authorRequest.toEntity())
        return ResponseEntity.ok().build()
    }
}