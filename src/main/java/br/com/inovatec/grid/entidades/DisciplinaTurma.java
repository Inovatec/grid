package br.com.inovatec.grid.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DisciplinaTurma extends Gerenciavel {
    
    @Id
    @SequenceGenerator(name = "DISCIPLINA_TURMA_ID", initialValue = 1, allocationSize = 1, sequenceName = "DISCIPLINA_TURMA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISCIPLINA_TURMA_ID")
    private Long id;
    
    @ManyToOne
    private Disciplina disciplina;
    
    @ManyToOne
    private Turma turma;
    
    public DisciplinaTurma() {
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "DisciplinaTurma{" + super.toString() + '}';
    }
    
}
