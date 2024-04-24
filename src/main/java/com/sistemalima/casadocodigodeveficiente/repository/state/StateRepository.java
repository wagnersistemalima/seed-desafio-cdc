package com.sistemalima.casadocodigodeveficiente.repository.state;

import com.sistemalima.casadocodigodeveficiente.repository.state.entity.StateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<StateEntity, Long> {
}
