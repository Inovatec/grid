package br.com.inovatec.grid.entidades;

import br.com.inovatec.grid.entidades.enums.TipoSala;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "sala.findAll", query = "SELECT s FROM Sala s")
})
public class Sala extends Gerenciavel {
    
    @Id
    @SequenceGenerator(name = "SALA_ID", initialValue = 1, allocationSize = 1, sequenceName = "SALA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALA_ID")
    private Long id;

    @Column(length = 100)
    private String nome;
    @Column(length = 255)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoSala tipoSala;

    public Sala() {
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

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + ", descricao=" + descricao + ", tipoSala=" + tipoSala + '}';
    }

}
