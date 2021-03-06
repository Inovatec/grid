package br.com.inovatec.grid.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "aula.findAll", query = "SELECT a FROM Aula a")
})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "AULA_ID", initialValue = 1, allocationSize = 1, sequenceName = "AULA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AULA_ID")
    private Long id;
    
    @ManyToOne
    private Professor professor;
    
    @ManyToOne
    private Sala sala;
    
    @ManyToOne
    private DisciplinaTurma disciplinaTurma;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Horario horario;

    public Aula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public DisciplinaTurma getDisciplinaTurma() {
        return disciplinaTurma;
    }

    public void setDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
        this.disciplinaTurma = disciplinaTurma;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Aula other = (Aula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", professor=" + professor + ", sala=" + sala + ", disciplina=" + disciplinaTurma + ", horario=" + horario + '}';
    }

}
