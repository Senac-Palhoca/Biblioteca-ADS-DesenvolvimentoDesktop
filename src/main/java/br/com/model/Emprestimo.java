package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Felipe.Stahlhofer
 */
@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRetirada;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPrevista;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;
    
    @ManyToOne()
    @JoinColumn(name = "idExemplar")
    private Exemplar exemplar;
    
    @ManyToOne()
    @JoinColumn(name = "idAluno")
    private Aluno aluno;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Date dataRetirada, Date dataPrevista, Date dataDevolucao) {
        this.dataRetirada = dataRetirada;
        this.dataPrevista = dataPrevista;
        this.dataDevolucao = dataDevolucao;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this. dataRetirada = dataRetirada;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this. dataPrevista = dataPrevista;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this. dataDevolucao = dataDevolucao;
    }
    
     public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
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
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo)object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "br.com.model.Emprestimo[ id=" + id + "]";
    }
}
