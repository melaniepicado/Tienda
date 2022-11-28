package com.tienda.domain;
import java.io.Serializable;
import javax.persistence.*; // "*" trae todo lo que esta dentro de persistence
import lombok.Data;

@Data
@Entity
@Table (name="cliente")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente; //Hibernate lo convierte en id_cliente
    private String nombre, apellidos, correo, telefono;
    
    @JoinColumn(name="id_credito", referencedColumnName="id_credito")
    @ManyToOne
    private Credito credito;

    public Cliente() {
    }
    
    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(Long idCliente, String apellidos, String correo, String telefono, Credito credito) {
        this.idCliente = idCliente;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
}
