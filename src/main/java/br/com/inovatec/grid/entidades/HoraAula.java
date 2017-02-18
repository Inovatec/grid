/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.entidades;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class HoraAula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "HORA_AULA_ID", initialValue = 1, allocationSize = 1, sequenceName = "HORA_AULA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HORA_AULA_ID")
    private Long id;
    
    @Column
    private LocalTime horaInicio;
    
    @Column
    private LocalTime horaFim;

    public HoraAula() {
    }

    public HoraAula(LocalTime horaInicio, LocalTime horaFim) {
        this();
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final HoraAula other = (HoraAula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HoraAula{" + "id=" + id + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + '}';
    }
    
}
