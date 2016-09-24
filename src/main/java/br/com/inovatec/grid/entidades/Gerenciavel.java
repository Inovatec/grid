package br.com.inovatec.grid.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * Classe que responsavel por indicar que a entidade filha é gerenciada pelo
 * módulo de geração da grade de horários. As classes que herdarem desta farão
 * parte da entidade Aula, a qual compõe a grade de horários presente na 
 * entidade Grade.
 * 
 * @author zrobe
 */
@MappedSuperclass
public abstract class Gerenciavel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Horario> horarios;

    public Gerenciavel() {
        this.horarios = new ArrayList<>();
    }

    public abstract Long getId();

    public abstract void setId(Long id);

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.getId());
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
        final Gerenciavel other = (Gerenciavel) obj;
        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gerenciavel{" + "id=" + this.getId() + ", horarios=" + horarios + '}';
    }

}
