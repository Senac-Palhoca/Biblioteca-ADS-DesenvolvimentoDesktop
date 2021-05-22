package br.com.senacalunos.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author
 */
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 20)
    private String senha;
    @Column(nullable = false)
    private String matricula;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cpf, String email, String senha, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this. nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this. cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this. email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this. senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this. matricula = matricula;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa)object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "br.com.modelo.Pessoa[ id=" + id + "]";
    }
}
