package com.sistemalima.casadocodigodeveficiente.controller

import com.sistemalima.casadocodigodeveficiente.controller.entity.AuthorRequest
import com.sistemalima.casadocodigodeveficiente.controller.mapper.AuthorRequestMapper.toEntity
import com.sistemalima.casadocodigodeveficiente.controller.validation.ProibeEmailDuplicadoValidator
import jakarta.persistence.EntityManager
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// total = 4 / limite maximo de 7 pontos
@Validated
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE], path = ["/autores"])
class AuthorController(
    private val entityManager: EntityManager,//1
    private val proibeEmailDuplicadoValidator: ProibeEmailDuplicadoValidator  //1
) {

    // métodos para inicializar
    @InitBinder
    protected fun init(binder: WebDataBinder) {
        binder.addValidators(proibeEmailDuplicadoValidator)
    }

    @PostMapping
    @Transactional
    fun create(
        @Valid @RequestBody authorRequest: AuthorRequest //1
    ): ResponseEntity<Any> {
        entityManager.persist(authorRequest.toEntity()) //1
        return ResponseEntity.ok().build()
    }
}