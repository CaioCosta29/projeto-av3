package com.example.denunciasja.model;

import jakarta.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column(name = "CEP", columnDefinition = "CHAR(8)", nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    @Column(name = "bairro", length = 100, nullable = false)
    private String bairro;

    @Column(name = "municipio", length = 100, nullable = false)
    private String municipio;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "complemento", length = 100, nullable = false)
    private String complemento;

    // Construtor padrão para JPA
    public Endereco() {

    }

    // Construtor com todos os campos (sem idEndereco, pois é gerado)
    public Endereco(String cep,
                    String logradouro,
                    String numero,
                    String bairro,
                    String municipio,
                    String estado,
                    String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.complemento = complemento;
    }
}
