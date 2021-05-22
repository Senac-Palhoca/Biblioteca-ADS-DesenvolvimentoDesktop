package br.com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Felipe.Stahlhofer
 */
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Aluno extends Pessoa implements Serializable {
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "emprestimo", fetch = FetchType.EAGER)
    //private List<Emprestimo> emprestimo;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String cpf, String email, String senha, String matricula) {
        super(id, nome, cpf, email, senha, matricula);
    }
    
//    public List<Emprestimo> getEmprestimo() {
//        return emprestimo;
//    }
//
//    public void setEmprestimo(List<Emprestimo> emprestimo) {
//        this.emprestimo = emprestimo;
//    }
}
