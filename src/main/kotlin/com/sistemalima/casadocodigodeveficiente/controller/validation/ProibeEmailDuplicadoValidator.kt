package com.sistemalima.casadocodigodeveficiente.controller.validation

import com.sistemalima.casadocodigodeveficiente.controller.entity.AuthorRequest
import com.sistemalima.casadocodigodeveficiente.repository.AuthorRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.Errors
import org.springframework.validation.Validator

// classe que tem a responsabilidade de ser uma validador customizado
// total = 5 / limite maximo de 7 pontos
@Component
class ProibeEmailDuplicadoValidator(
    private val authorRepository: AuthorRepository //1
): Validator {

    // suport -> qual o tipo de parametro que podemos aplicar a validação = AuthorRequest
    // essa classe pode ser iqual a essa ou filha
    override fun supports(clazz: Class<*>): Boolean {
        return AuthorRequest::class.java.isAssignableFrom(clazz)
    }

    // Aplicando a validação

    @Transactional(readOnly = true)
    override fun validate(target: Any, errors: Errors) {
        // so vai rodar se nao tiver alguma erro de validação ate aquele momento
        if (errors.hasErrors()) {
            return
        }

        val request: AuthorRequest  = target as AuthorRequest

        if (authorRepository.findByEmail(request.email).isPresent) { //1 + 1
            errors.rejectValue("email", "400", "Não foi possivel realisar cadastro, detalhes: email: ${request.email} ja cadastrado")
        }
    }
}