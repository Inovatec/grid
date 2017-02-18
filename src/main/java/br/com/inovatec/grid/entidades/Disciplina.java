package br.com.inovatec.grid.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "disciplina.findAll", query = "SELECT d FROM Disciplina d")
})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "DISCIPLINA_ID", initialValue = 1, allocationSize = 1, sequenceName = "DISCIPLINA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISCIPLINA_ID")
    private Long id;

    @Column(length = 100)
    private String nome;
    @Column(length = 255)
    private String descricao;

    public Disciplina() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Disciplina{" + super.toString() + ", nome=" + nome + ", descricao=" + descricao + '}';
    }

}
