package com.projeto_av3.projeto_av3.model;

import com.projeto_av3.projeto_av3.model.enums.Genero;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(nullable = false, unique = true, length = 11, columnDefinition = "char(11)")
    private String cpf;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 9)
    private String telefone;


    @Column(nullable = false, columnDefinition="CHAR(1)")
    private String genero;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 200, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String cpf, String nome, String telefone, String genero, String senha, LocalDate dataNascimento, String email, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.genero = genero;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
