package br.edu.ifnmg.web.grupostrabalho.endereco;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Endereco")
@Table(name = "tbl_endereco")
public class Endereco implements Serializable {

    public enum TipoLogradouro {
        RUA, AVENIDA, PRACA, OUTRO;
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private TipoLogradouro tipoLogradouro;

    @Column(length = 150, nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private Integer numero;

    @Column(length = 25, nullable = false)
    private String bairro;

    public Endereco() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", tipoLogradouro=" + tipoLogradouro + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + '}';
    }

}
