package br.com.inovatec.grid.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "professor.findAll", query = "SELECT p FROM Professor p")
})
public class Professor extends Gerenciavel {

    @Id
    @SequenceGenerator(name = "PROFESSOR_ID", initialValue = 1, allocationSize = 1, sequenceName = "PROFESSOR_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFESSOR_ID")
    private Long id;
    
    @Column(length = 100)
    private String nome;
    @Column(length = 50)
    private String rg;
    @Column(length = 11)
    private String cpf;
    private List<String> telefones;
    @Column(length = 100)
    private String email;
    
    @Embedded
    private Endereco endereco;
    
    @ManyToMany
    private List<Disciplina> disciplinas;

    public Professor() {
        super();
        this.telefones = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", telefones=" + telefones + ", email=" + email + ", endereco=" + endereco + '}';
    }

}
