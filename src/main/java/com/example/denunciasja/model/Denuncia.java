package com.example.denunciasja.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncia")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia")
    private Integer idDenuncia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "fk_denuncia_usuario"))
    private Usuario usuario;

    @Column(name = "data", nullable = false, columnDefinition = "DATETIME(2)")
    private LocalDateTime data;

    @Column(name = "tipo_violencia", length = 11, nullable = false)
    private String tipoViolencia;

    @Column(name = "denunciante_e_vitima", nullable = false, columnDefinition = "TINYINT")
    private Boolean denuncianteEVitima;

    @Column(name = "possui_vinculo_agressor", nullable = false, columnDefinition = "TINYINT")
    private Boolean possuiVinculoAgressor;

    @Column(name = "agressor_armado", nullable = false, columnDefinition = "TINYINT")
    private Boolean agressorArmado;

    @Column(name = "localizacao", length = 150, nullable = false)
    private String localizacao;

    @Column(name = "ponto_referencia", length = 100, nullable = false)
    private String pontoReferencia;

    @Column(name = "descricao_agressor", length = 200, columnDefinition = "VARCHAR(200)", nullable = false)
    private String descricaoAgressor;

    public Denuncia() { }

    public Denuncia(Usuario usuario,
                    LocalDateTime data,
                    String tipoViolencia,
                    Boolean denuncianteEVitima,
                    Boolean possuiVinculoAgressor,
                    Boolean agressorArmado,
                    String localizacao,
                    String pontoReferencia,
                    String descricaoAgressor) {
        this.usuario = usuario;
        this.data = data;
        this.tipoViolencia = tipoViolencia;
        this.denuncianteEVitima = denuncianteEVitima;
        this.possuiVinculoAgressor = possuiVinculoAgressor;
        this.agressorArmado = agressorArmado;
        this.localizacao = localizacao;
        this.pontoReferencia = pontoReferencia;
        this.descricaoAgressor = descricaoAgressor;
    }

    public Integer getIdDenuncia() {
        return idDenuncia;
    }
    public void setIdDenuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
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

    public String getTipoViolencia() {
        return tipoViolencia;
    }
    public void setTipoViolencia(String tipoViolencia) {
        this.tipoViolencia = tipoViolencia;
    }

    public Boolean getDenuncianteEVitima() {
        return denuncianteEVitima;
    }
    public void setDenuncianteEVitima(Boolean denuncianteEVitima) {
        this.denuncianteEVitima = denuncianteEVitima;
    }

    public Boolean getPossuiVinculoAgressor() {
        return possuiVinculoAgressor;
    }
    public void setPossuiVinculoAgressor(Boolean possuiVinculoAgressor) {
        this.possuiVinculoAgressor = possuiVinculoAgressor;
    }

    public Boolean getAgressorArmado() {
        return agressorArmado;
    }
    public void setAgressorArmado(Boolean agressorArmado) {
        this.agressorArmado = agressorArmado;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }
    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getDescricaoAgressor() {
        return descricaoAgressor;
    }
    public void setDescricaoAgressor(String descricaoAgressor) {
        this.descricaoAgressor = descricaoAgressor;
    }
}

