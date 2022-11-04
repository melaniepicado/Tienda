package com.tienda.service;

//Capa Intermedia = Capa de Negocio
import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    public List<Articulo> getArticulos();
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
}
