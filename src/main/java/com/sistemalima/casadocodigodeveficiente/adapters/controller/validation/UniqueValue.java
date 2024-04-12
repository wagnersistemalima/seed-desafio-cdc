package com.sistemalima.casadocodigodeveficiente.adapters.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({FIELD})  // vai ser aplicada em atributos
@Retention(RUNTIME) // vai ser lida em runtime, tempo de execução
public @interface UniqueValue {

    String message () default "{bean validation unique value}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String fieldName();

    Class<?> domainClass();
}
