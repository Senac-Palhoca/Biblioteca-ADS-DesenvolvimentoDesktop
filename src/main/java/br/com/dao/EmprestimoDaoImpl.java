/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Aluno;
import br.com.model.Emprestimo;
import br.com.model.Turma;
import java.util.Date;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author Felip
 */
public class EmprestimoDaoImpl extends BaseDaoImpl<Emprestimo, Long> implements EmprestimoDao {

    @Override
    public Emprestimo pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Emprestimo) sessao.get(Emprestimo.class, id);
    }

    @Override
    public List<Emprestimo> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Emprestimo"));
        return consulta.list();
    }

    @Override
    public List<Emprestimo> pesquisarPorAlunoAberto(String nome, Session sessao) throws HibernateException {
        StringBuilder sql = new StringBuilder("from Emprestimo e where dataDevolucao is null ");
        if (!nome.equals("")) {
            sql.append("and e.aluno.nome like :nome order by e.aluno.nome");
        } else {
            sql.append("order by e.aluno.nome");
            return sessao.createQuery(sql.toString()).list();
        }
        Query consulta = sessao.createQuery(sql.toString());
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }
    
    @Override
    public List<Emprestimo> pesquisarPorAlunoAbertoId(Long id, Session sessao) throws HibernateException {
        StringBuilder sql = new StringBuilder("from Emprestimo e where ");
        sql.append("dataDevolucao is null and e.aluno.id like :id");
        Query consulta = sessao.createQuery(sql.toString());
        consulta.setParameter("id", id);
        return consulta.list();
    }

    @Override
    public List<Emprestimo> pesquisarPorTurmaMes(Turma turma, String mes, String ano, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Emprestimo e where e.aluno.turma.id = :turma and DATE_FORMAT(e.dataRetirada, '%Y%m') = :anoMes");
        consulta.setParameter("turma", turma.getId());
        consulta.setParameter("anoMes", ano + mes);
        return consulta.list();
    }

    @Override
    public List<Emprestimo> pesquisarPorAlunoMes(Aluno aluno, String mes, String ano, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Emprestimo e where e.aluno.id = :aluno and DATE_FORMAT(e.dataRetirada, '%Y%m') = :anoMes");
        consulta.setParameter("aluno", aluno.getId());
        consulta.setParameter("anoMes", ano + mes);
        return consulta.list();
    }

    @Override
    public List<Emprestimo> listarTodosEmAberto(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Emprestimo where dataDevolucao is null");
        return consulta.list();
    }

    @Override
    public List<Emprestimo> listarAtrasados(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Emprestimo where dataPrevista < :data and dataDevolucao is null");
        consulta.setParameter("data", new Date());
        return consulta.list();
    }

}
