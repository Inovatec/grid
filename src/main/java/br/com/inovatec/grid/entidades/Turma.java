package br.com.inovatec.grid.entidades;

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
    @NamedQuery(name = "turma.findAll", query = "SELECT t FROM Turma t")
})
public class Turma extends Gerenciavel {

    @Id
    @SequenceGenerator(name = "TURMA_ID", initialValue = 1, allocationSize = 1, sequenceName = "TURMA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TURMA_ID")
    private Long id;
    
    private int ano;
    @Column(length = 2)
    private String acronimo;
    @Column(length = 255)
    private String descricao;

    public Turma() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Turma{" + super.toString() + ", ano=" + ano + ", acronimo=" + acronimo + ", descricao=" + descricao + '}';
    }

}
