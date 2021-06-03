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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno", fetch = FetchType.EAGER)
    private List<Emprestimo> emprestimos;
    
    @ManyToOne()
    @JoinColumn(name = "idTurma")
    private Turma turma;
    
    public Aluno() {
    }

    public Aluno(Long id, String nome, String cpf, String email, String senha, String matricula) {
        super(id, nome, cpf, email, senha, matricula);
    }
    
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimo) {
        this.emprestimos = emprestimo;
    }
    
    
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}