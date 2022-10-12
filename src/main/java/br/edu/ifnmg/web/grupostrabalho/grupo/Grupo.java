package br.edu.ifnmg.web.grupostrabalho.grupo;

import br.edu.ifnmg.web.grupostrabalho.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Grupo")
@Table(name = "tbl_grupo")
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65, nullable = false)
    private String nome;

    private Boolean ativo;
    
    @OneToOne
    @JoinColumn(name = "lider_pessoa_id")
    private Pessoa lider;

    public Grupo() {
        this.ativo = true;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }
    
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", nome=" + nome + ", ativo=" + ativo + '}';
    }

}
