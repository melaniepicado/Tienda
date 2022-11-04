package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*; // "*" trae todo lo que esta dentro de persistence

import lombok.Data;

@Data
@Entity
@Table (name="credito")
public class Credito implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_credito")
    private Long idCredito, limite;

    public Credito() {
    }

    public Credito(Long limite) {
        this.limite = limite;
    }

    public Credito getCredito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
