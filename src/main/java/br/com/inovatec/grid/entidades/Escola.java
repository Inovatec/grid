/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author zrobe
 */
@Entity
@NamedQueries(value = {
    @NamedQuery(name = "escola.findAll", query = "SELECT e FROM Escola e")
})
public class Escola implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "ESCOLA_ID", initialValue = 1, allocationSize = 1, sequenceName = "ESCOLA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESCOLA_ID")
    private Long id;
    
    @Column(length = 100)
    private String nome;
    private int duracaoAula;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<DiaAula> diasAulas;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<HoraAula> horasAulas;

    public Escola() {
        this.diasAulas = new ArrayList<>();
        this.horasAulas = new ArrayList<>();
    }

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

    public int getDuracaoAula() {
        return duracaoAula;
    }

    public void setDuracaoAula(int duracaoAula) {
        this.duracaoAula = duracaoAula;
    }

    public List<DiaAula> getDiasAulas() {
        return diasAulas;
    }

    public void setDiasAulas(List<DiaAula> diasAulas) {
        this.diasAulas = diasAulas;
    }

    public List<HoraAula> getHorasAulas() {
        return horasAulas;
    }

    public void setHorasAulas(List<HoraAula> horasAulas) {
        this.horasAulas = horasAulas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Escola other = (Escola) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Escola{" + "id=" + id + ", nome=" + nome + ", duracaoAula=" + duracaoAula + ", diasAulas=" + diasAulas + ", horasAulas=" + horasAulas + '}';
    }
    
}
