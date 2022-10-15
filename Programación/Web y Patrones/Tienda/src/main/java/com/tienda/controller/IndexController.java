package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired //Crea instancia de forma automatica
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura mvc");
        
        var clientes = clienteService.getClientes();
                
        model.addAttribute("clientes", clientes);
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "ModificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
}
