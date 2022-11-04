package com.tienda.dao;

import com.tienda.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloDao extends CrudRepository<Articulo, Long> {
    //Contiene diferentes métodos para consultar la base de datos
}
