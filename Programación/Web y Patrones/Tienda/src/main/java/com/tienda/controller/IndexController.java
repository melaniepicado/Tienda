package com.tienda.controller;

import com.tienda.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired //Crea instancia de forma automatica
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura mvc");
        
        var articulos = articuloService.getArticulos(true);
                
        model.addAttribute("articulos", articulos);
        return "index";        

//        var articulos = articuloService.getPorDescripcion("AMD 670");
//                
//        model.addAttribute("articulos", articulos);
//        return "index";
    }
}
