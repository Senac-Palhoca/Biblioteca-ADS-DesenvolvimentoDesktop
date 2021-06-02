/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "exemplar")
public class Exemplar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;
    @Column(nullable = false, unique = true)
    private String codigoLivro;
    
    @OneToMany(mappedBy = "exemplar")
    private List<Emprestimo> emprestimo;

    public Exemplar() {
    }

    public Exemplar(String codigoLivro) {
        this.status = true;
        this.codigoLivro = codigoLivro;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this. status = status;
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(String codigoLivro) {
        this. codigoLivro = codigoLivro;
    }
    
    
    public List<Emprestimo> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(List<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
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
        if (!(object instanceof Exemplar)) {
            return false;
        }
        Exemplar other = (Exemplar)object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "br.com.modelo.Exemplar[ id=" + id + "]";
    }
}
