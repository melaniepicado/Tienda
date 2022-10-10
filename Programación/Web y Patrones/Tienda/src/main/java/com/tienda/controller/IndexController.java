package com.tienda.controller;

import com.tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura mvc");
        Cliente cliente1 = new Cliente("Pedro", "Gomez", "pgomez@gmail.com","4563-1208");
        Cliente cliente2 = new Cliente("Rebeca", "Arguedas", "arebeca@gmail.com","7410-9563");
        
        var clientes = Arrays.asList(cliente1,cliente2);
                
        model.addAttribute("clientes", clientes);
        return "index";
    }
}
