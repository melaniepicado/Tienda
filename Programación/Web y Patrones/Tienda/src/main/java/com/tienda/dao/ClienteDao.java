package com.tienda.dao;

import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
    //Contiene diferentes métodos para consultar la base de datos
    
    @Query("SELECT p FROM Cliente p WHERE p.apellidos LIKE %?1%")
    List<Cliente> findByApellidos(String apellidos);
}
