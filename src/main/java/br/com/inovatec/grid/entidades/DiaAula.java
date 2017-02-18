/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.entidades;

import br.com.inovatec.grid.entidades.enums.Turno;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author zrobe
 */
@Entity
@NamedQueries(value = {
    @NamedQuery(name = "diaAula.findAll", query = "SELECT da FROM DiaAula da")
})
public class DiaAula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "DIA_AULA_ID", initialValue = 1, allocationSize = 1, sequenceName = "DIA_AULA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIA_AULA_ID")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaDaSemana;
    private int totalAulas;
    
    @Enumerated(EnumType.STRING)
    private Turno turno;

    public DiaAula() {
    }

    public DiaAula(DayOfWeek diaDaSemana, int totalAulas, Turno turno) {
        this.diaDaSemana = diaDaSemana;
        this.totalAulas = totalAulas;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DayOfWeek diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public void setTotalAulas(int totalAulas) {
        this.totalAulas = totalAulas;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final DiaAula other = (DiaAula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DiaAula{" + "id=" + id + ", diaDaSemana=" + diaDaSemana + ", totalAulas=" + totalAulas + ", turno=" + turno + '}';
    }
    
}
