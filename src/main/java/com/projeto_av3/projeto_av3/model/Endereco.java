package com.projeto_av3.projeto_av3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column(nullable = false, length = 255)
    private String rua;

    @Column(nullable = false, length = 15)
    private String numero;

    @Column(nullable = false, length = 100)
    private String complemento;

    @Column(nullable = false, length = 75)
    private String cidade;

    @Column(nullable = false, length = 50)
    private String estado;

    @Column(nullable = false, length = 8, columnDefinition = "char(8)")
    private String cep;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String complemento, String estado, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }
}
