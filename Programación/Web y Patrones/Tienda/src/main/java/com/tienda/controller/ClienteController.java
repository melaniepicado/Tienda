package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    
    @Autowired //Crea instancia de forma automatica
    private ClienteService clienteService;
    
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();
        
        var limiteTotal=0;
        for (var c: clientes) {
            limiteTotal+=c.getCredito().getLimite();
        }
        model.addAttribute("limiteTotal",limiteTotal);
        model.addAttribute("totalClientes",clientes.size());
        
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modifica";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping ("/cliente/modifica/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }
    
    @GetMapping ("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/encontrar")
    public String encontrarCliente(Model model, @Param("apellidos") String apellidos){
        List<Cliente> porApellidos = clienteService.getPorApellidos(apellidos);
        //var apellidos = clienteService.getPorApellidos("");
        model.addAttribute("porApellidos", porApellidos);
        return "/cliente/encontrar";
    }
}
