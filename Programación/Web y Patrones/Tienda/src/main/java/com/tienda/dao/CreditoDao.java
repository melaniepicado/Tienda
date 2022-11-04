package com.tienda.dao;

import com.tienda.domain.Credito;
import org.springframework.data.repository.CrudRepository;

public interface CreditoDao extends CrudRepository<Credito, Long> {
    //Contiene diferentes métodos para consultar la base de datos
}
