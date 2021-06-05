/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Aluno;
import br.com.model.Turma;
import java.util.Date;
import java.util.List;
import org.hibernate.*;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Felip
 */
public class AlunoDaoImpl extends BaseDaoImpl<Aluno, Long> implements AlunoDao{
    @Override
    public Aluno pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Aluno) sessao.get(Aluno.class, id);
    }
    
    @Override
    public List<Aluno> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Aluno where nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }
    
    @Override
    public List<Aluno> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Aluno order by nome"));
        return consulta.list();
    }

    @Override
    public List<Aluno> pesquisarPorMatricula(String matricula, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Aluno where matricula like :matricula");
        consulta.setParameter("matricula", "%" + matricula + "%");
        return consulta.list();
    }

    @Override
    public List<Aluno> pesquisarPorTurma(Turma turma, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Aluno where idTurma like :idTurma");
        consulta.setParameter("idTurma", turma.getId());
        return consulta.list();
    }

    @Override
    public List<Object[]> listarRankingMes(Date data, long idTurma, Session sessao) throws HibernateException {
        //SELECT * , count(*) as count FROM biblioteca.aluno as a INNER JOIN biblioteca.pessoa p ON p.id = a.idPessoa INNER JOIN biblioteca.emprestimo as e ON e.idAluno = p.id where dataRetirada like '2021-06%' GROUP BY p.id order by count DESC;
        Query consulta = sessao.createQuery("from Aluno aluno JOIN aluno.emprestimos AS emprestimo where aluno.turma.id = :idTurma and year(emprestimo.dataRetirada)=year(:data) and month(emprestimo.dataRetirada)=month(:data) group by aluno.id order by count(aluno.id) DESC");
        consulta.setParameter("data", data);
        consulta.setParameter("idTurma", idTurma);
        //consulta.setResultTransformer(Transformers.aliasToBean(Aluno.class));        
        return consulta.list();
    }
}
