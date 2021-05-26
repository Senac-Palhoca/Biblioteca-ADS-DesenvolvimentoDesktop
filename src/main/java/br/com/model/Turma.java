package br.com.model;

import br.com.model.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Titione.Amorim
 */
@Entity
@Table(name = "turma")
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String fase;
    @Column(length = 4)
    private String ano;
    @Column(length = 45)
    private String periodo;
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    public Turma() {
    }

    public Turma(Long id, String fase, String ano, String periodo) {
        this.fase = fase;
        this.ano = ano;
        this.periodo = periodo;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this. fase = fase;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this. ano = ano;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this. periodo = periodo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma)object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "br.com.modelo.Turma[ id=" + id + "]";
    }
}
