package com.tienda.service;

//Capa Intermedia = Capa de Negocio
import com.tienda.domain.Credito;
import java.util.List;

public interface CreditoService {
    public List<Credito> getCreditos();
    
    public void save(Credito credito);
    
    public void delete(Credito credito);
    
    public Credito getCredito(Credito credito);
}
