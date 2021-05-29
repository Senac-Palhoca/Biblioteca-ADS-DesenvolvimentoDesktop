/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Aluno;
import br.com.model.Curso;
import java.util.List;
import org.hibernate.*;

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
        Query consulta = sessao.createQuery(("FROM Aluno"));
        return consulta.list();
    }

    @Override
    public List<Aluno> pesquisarPorMatricula(String matricula, Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> pesquisarPorCurso(Curso curso, Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> listarRankingMes(Integer mes, Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
