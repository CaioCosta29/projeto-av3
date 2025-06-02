package com.example.denunciasja.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "boletim")
public class Boletim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boletim")
    private Integer idBoletim;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "fk_boletim_usuario1"))
    private Usuario usuario;

    @Column(name = "data", nullable = false, columnDefinition = "DATETIME(2)")
    private LocalDateTime data;

    @Column(name = "vitima_nome", length = 120, nullable = false)
    private String vitimaNome;

    @Column(name = "vitima_idade", nullable = false)
    private Integer vitimaIdade;

    @Column(name = "vitima_cpf", columnDefinition = "CHAR(11)", nullable = false)
    private String vitimaCpf;

    @Column(name = "vitima_telefone", columnDefinition = "CHAR(14)", nullable = false)
    private String vitimaTelefone;

    @Column(name = "lesoes", columnDefinition = "TEXT")
    private String lesoes;

    @Column(name = "descricao_fato", columnDefinition = "TEXT", nullable = false)
    private String descricaoFato;

    @Column(name = "agressor_armado", nullable = false, columnDefinition = "TINYINT")
    private Boolean agressorArmado;

    @Column(name = "possui_vinculo_agressor", nullable = false, columnDefinition = "TINYINT")
    private Boolean possuiVinculoAgressor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_endereco", nullable = false,
            foreignKey = @ForeignKey(name = "fk_boletim_endereco1"))
    private Endereco endereco;

    public Boletim() { }

    public Boletim(Usuario usuario,
                   LocalDateTime data,
                   String vitimaNome,
                   Integer vitimaIdade,
                   String vitimaCpf,
                   String vitimaTelefone,
                   String lesoes,
                   String descricaoFato,
                   Boolean agressorArmado,
                   Boolean possuiVinculoAgressor,
                   Endereco endereco) {
        this.usuario = usuario;
        this.data = data;
        this.vitimaNome = vitimaNome;
        this.vitimaIdade = vitimaIdade;
        this.vitimaCpf = vitimaCpf;
        this.vitimaTelefone = vitimaTelefone;
        this.lesoes = lesoes;
        this.descricaoFato = descricaoFato;
        this.agressorArmado = agressorArmado;
        this.possuiVinculoAgressor = possuiVinculoAgressor;
        this.endereco = endereco;
    }

    // ─────── Getters e setters ───────

    public Integer getIdBoletim() {
        return idBoletim;
    }

    public void setIdBoletim(Integer idBoletim) {
        this.idBoletim = idBoletim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getVitimaNome() {
        return vitimaNome;
    }

    public void setVitimaNome(String vitimaNome) {
        this.vitimaNome = vitimaNome;
    }

    public Integer getVitimaIdade() {
        return vitimaIdade;
    }

    public void setVitimaIdade(Integer vitimaIdade) {
        this.vitimaIdade = vitimaIdade;
    }

    public String getVitimaCpf() {
        return vitimaCpf;
    }

    public void setVitimaCpf(String vitimaCpf) {
        this.vitimaCpf = vitimaCpf;
    }

    public String getVitimaTelefone() {
        return vitimaTelefone;
    }

    public void setVitimaTelefone(String vitimaTelefone) {
        this.vitimaTelefone = vitimaTelefone;
    }

    public String getLesoes() {
        return lesoes;
    }

    public void setLesoes(String lesoes) {
        this.lesoes = lesoes;
    }

    public String getDescricaoFato() {
        return descricaoFato;
    }

    public void setDescricaoFato(String descricaoFato) {
        this.descricaoFato = descricaoFato;
    }

    public Boolean getAgressorArmado() {
        return agressorArmado;
    }

    public void setAgressorArmado(Boolean agressorArmado) {
        this.agressorArmado = agressorArmado;
    }

    public Boolean getPossuiVinculoAgressor() {
        return possuiVinculoAgressor;
    }

    public void setPossuiVinculoAgressor(Boolean possuiVinculoAgressor) {
        this.possuiVinculoAgressor = possuiVinculoAgressor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}
