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
public class EmprestimoDaoImpl extends BaseDaoImpl<Emprestimo, Long> implements EmprestimoDao{
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
    public List<Emprestimo> pesquisarPorAlunoAberto(Aluno aluno, Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> pesquisarPorTurmaMes(Turma turma, Integer mes, Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> pesquisarPorAlunoMes(Aluno aluno, Integer mes, Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> listarTodosEmAberto(Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
