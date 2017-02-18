package br.com.inovatec.grid.entidades;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "HORARIO_ID", initialValue = 1, allocationSize = 1, sequenceName = "HORARIO_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HORARIO_ID")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaDaSemana;

    @Column
    private LocalTime inicio;
    
    @Column
    private LocalTime fim;

    public Horario() {
    }

    public Horario(DayOfWeek diaDaSemana, LocalTime inicio, LocalTime fim) {
        this.diaDaSemana = diaDaSemana;
        this.inicio = inicio;
        this.fim = fim;
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

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
        this.fim = fim;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Horario other = (Horario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", diaDaSemana=" + diaDaSemana + ", inicio=" + inicio + ", fim=" + fim + '}';
    }

}
