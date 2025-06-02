package com.example.denunciasja.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "cpf", columnDefinition = "CHAR(11)", nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome_completo", length = 150, nullable = false)
    private String nomeCompleto;

    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    @Column(name = "telefone", length = 14, nullable = false, columnDefinition = "CHAR(14)")
    private String telefone;

    @Column(name = "genero", nullable = false, columnDefinition = "CHAR(8)")
    private String genero;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email", length = 200, nullable = false, unique = true)
    private String email;

    @Column(name = "nome_contato_emergencia", length = 150, nullable = false)
    private String nomeContatoEmergencia;

    @Column(name = "telefone_contato_emergencia", length = 14, nullable = false, columnDefinition = "CHAR(14)")
    private String telefoneContatoEmergencia;

    public Usuario() {

    }

    public Usuario(String cpf, String nomeCompleto, String senha, String telefone, String genero,
                   LocalDate dataNascimento,
                   String email,
                   String nomeContatoEmergencia,
                   String telefoneContatoEmergencia) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.telefone = telefone;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nomeContatoEmergencia = nomeContatoEmergencia;
        this.telefoneContatoEmergencia = telefoneContatoEmergencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getNomeContatoEmergencia() {
        return nomeContatoEmergencia;
    }

    public void setNomeContatoEmergencia(String nomeContatoEmergencia) {
        this.nomeContatoEmergencia = nomeContatoEmergencia;
    }

    public String getTelefoneContatoEmergencia() {
        return telefoneContatoEmergencia;
    }

    public void setTelefoneContatoEmergencia(String telefoneContatoEmergencia) {
        this.telefoneContatoEmergencia = telefoneContatoEmergencia;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
